package me.dio.carrinhoCompra.service

import me.dio.carrinhoCompra.enumeration.FormaPagamento
import me.dio.carrinhoCompra.model.Item
import me.dio.carrinhoCompra.model.Sacola
import me.dio.carrinhoCompra.resource.dto.ItemDto
import org.springframework.stereotype.Service

@Service
interface SacolaService {
    fun verSacola (id : Long): Sacola
    fun fecharSacola (id : Long, formaPagamento: FormaPagamento): Sacola
    fun incluirItem (itemDto : ItemDto): Item

}