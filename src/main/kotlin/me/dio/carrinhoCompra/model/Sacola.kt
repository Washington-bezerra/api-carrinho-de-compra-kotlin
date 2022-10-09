package me.dio.carrinhoCompra.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.Getter
import lombok.NoArgsConstructor
import me.dio.carrinhoCompra.enumeration.FormaPagamento
import javax.persistence.*

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Builder
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
class Sacola(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private var cliente: Cliente? = null,

    @OneToMany(cascade = [CascadeType.ALL])
    private var itens: MutableList<Item>? = null,
    private var valorTotal: Double = 0.0,

    @Enumerated
    private var formaPagamento: FormaPagamento? = null,
    private var fechada: Boolean = false,


){
    fun getItens(): MutableList<Item>{
        return this.itens!!
    }

    fun setFormaPagamento(formaPagamento: FormaPagamento) {
        this.formaPagamento = formaPagamento
    }

    fun setFechada(status: Boolean) {
        this.fechada = status
    }

    fun isFechada(): Boolean {
        return this.fechada
    }
}
