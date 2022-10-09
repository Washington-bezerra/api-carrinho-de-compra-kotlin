package me.dio.carrinhoCompra.controller

import lombok.RequiredArgsConstructor
import me.dio.carrinhoCompra.enumeration.FormaPagamento
import me.dio.carrinhoCompra.model.Item
import me.dio.carrinhoCompra.model.Sacola
import me.dio.carrinhoCompra.resource.dto.ItemDto
import me.dio.carrinhoCompra.service.SacolaService
import me.dio.carrinhoCompra.service.impl.SacolaServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ifood-devweek/sacola")
class SacolaController {

    @Autowired
    lateinit var sacolaService: SacolaServiceImpl

    @PostMapping
    fun incluirItem (@RequestBody itemDto: ItemDto): Item{
        return sacolaService.incluirItem(itemDto)
    }

    @GetMapping("/{id}")
    fun verSacola (@PathVariable id: Long) : Sacola{
        return sacolaService.verSacola(id)
    }

    @PatchMapping("/fechaSacola/{sacolaId}")
    fun fecharSacola(@PathVariable("sacolaId") sacolaId: Long,
                     @RequestParam("formaPagamento") formaPagamento: FormaPagamento) : Sacola{
        return sacolaService.fecharSacola(sacolaId, formaPagamento);
    }
}