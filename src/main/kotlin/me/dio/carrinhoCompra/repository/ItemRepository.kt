package me.dio.carrinhoCompra.repository

import me.dio.carrinhoCompra.model.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<Item, Long>{
}