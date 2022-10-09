package me.dio.carrinhoCompra.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import me.dio.carrinhoCompra.model.Endereco
import me.dio.carrinhoCompra.model.Produto
import javax.persistence.*

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
@Table(name = "restaurante")
data class Restaurante(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long? = null,
    private var nome: String? = null,

    @OneToMany(cascade = [CascadeType.ALL])
    private var cardapio: List<Produto>? = null,

    @Embedded
    private var endereco: Endereco? = null
)