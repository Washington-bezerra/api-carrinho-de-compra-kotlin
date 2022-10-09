package me.dio.carrinhoCompra.service.impl

import me.dio.carrinhoCompra.enumeration.FormaPagamento
import me.dio.carrinhoCompra.model.Item
import me.dio.carrinhoCompra.model.Sacola
import me.dio.carrinhoCompra.repository.ItemRepository
import me.dio.carrinhoCompra.repository.ProdutoRepository
import me.dio.carrinhoCompra.repository.SacolaRepository
import me.dio.carrinhoCompra.resource.dto.ItemDto
import me.dio.carrinhoCompra.service.SacolaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SacolaServiceImpl : SacolaService{
    @Autowired
    lateinit var sacolaRepository : SacolaRepository
    @Autowired
    lateinit var produtoRepository : ProdutoRepository
    @Autowired
    lateinit var itemRepository : ItemRepository

    override fun verSacola(id: Long): Sacola {
        return sacolaRepository.findById(id).orElseThrow { throw RuntimeException ("Couldn't find") }
    }

    override fun fecharSacola(id: Long, formaPagamento: FormaPagamento): Sacola {
        val sacola = verSacola(id)
        if (sacola.getItens().isEmpty()){
            throw RuntimeException ("Couldn't find sacola")
        }

        sacola.setFormaPagamento(formaPagamento)
        sacola.setFechada(true)
        return sacolaRepository.save(sacola)
    }

    override fun incluirItem(itemDto: ItemDto): Item {
        val sacola = verSacola(itemDto.getSacolaId())

        if(sacola.isFechada()){
            throw RuntimeException ("Sacola está fechada")
        }

        val itemParaSerInserido = Item()
        itemParaSerInserido.setQuantidade(itemDto.getQuantidade())
        itemParaSerInserido.setSacola(sacola)
        itemParaSerInserido.setProduto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow{throw RuntimeException("Esse produto não exite")})

        val itensSacola = sacola.getItens()

        if(itensSacola.isEmpty()){
            itensSacola.add(itemParaSerInserido)
        }else{
            val restauranteAtual = itensSacola[0].getProduto().getRestaurante();
            val restauranteASerInserido = itemParaSerInserido.getProduto().getRestaurante();
            if(restauranteAtual.equals(restauranteASerInserido)){
                itensSacola.add(itemParaSerInserido)
            }else{
                throw RuntimeException ("Não é possível adicionar produtos de restaurantes diferentes")
            }
        }
        sacolaRepository.save(sacola)

        return itemRepository.save(itemParaSerInserido)

    }
}