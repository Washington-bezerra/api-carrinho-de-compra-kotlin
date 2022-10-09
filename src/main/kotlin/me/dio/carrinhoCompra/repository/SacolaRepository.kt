package me.dio.carrinhoCompra.repository

import me.dio.carrinhoCompra.model.Sacola
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SacolaRepository : JpaRepository<Sacola, Long> {
}