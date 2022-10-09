package me.dio.carrinhoCompra.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import me.dio.carrinhoCompra.model.Restaurante
import javax.persistence.*

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long? = null,
    private var nome: String? = null,
    private var valorUnitario: Double? = 0.0,

    @Builder.Default
    private var disponivel: Boolean? = true,

    @JsonIgnore
    @ManyToOne
    private var restaurante: Restaurante? = null,
){
    fun getRestaurante() : Restaurante{
        return restaurante!!
    }
}