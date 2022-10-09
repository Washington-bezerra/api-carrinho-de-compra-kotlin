package me.dio.carrinhoCompra.repository

import me.dio.carrinhoCompra.model.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository : JpaRepository<Produto, Long>{
}