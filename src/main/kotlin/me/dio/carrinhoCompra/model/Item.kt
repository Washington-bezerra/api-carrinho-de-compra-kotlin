package me.dio.carrinhoCompra.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
class Item (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long = 0,

    @OneToOne
    private var produto: Produto? = null,
    private var quantidade: Int = 0,

    @ManyToOne
    @JsonIgnore
    private var sacola: Sacola? = null
){
    fun getProduto(): Produto {
        return produto!!
    }

    fun setProduto(produto: Produto){
        this.produto = produto
    }
    fun setQuantidade(quantidade: Int){
        this.quantidade = quantidade
    }
    fun setSacola(sacola: Sacola){
        this.sacola = sacola
    }
}
