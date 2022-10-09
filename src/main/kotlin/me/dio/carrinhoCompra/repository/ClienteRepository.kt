package me.dio.carrinhoCompra.repository

import me.dio.carrinhoCompra.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long> {
}