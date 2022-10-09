package me.dio.carrinhoCompra.resource.dto

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Embeddable

@AllArgsConstructor
@Data
@Embeddable
@NoArgsConstructor
@Builder
class ItemDto (

    private val produtoId: Long = 0,
    private val quantidade: Int = 0,
    private val sacolaId: Long = 0,

){
    fun getSacolaId() : Long{
        return this.sacolaId
    }

    fun getQuantidade() : Int{
        return this.quantidade
    }

    fun getProdutoId() : Long{
        return this.produtoId
    }
}
