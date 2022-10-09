package me.dio.carrinhoCompra.repository

import me.dio.carrinhoCompra.model.Restaurante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RestauranteRepository : JpaRepository<Restaurante, Long> {
}