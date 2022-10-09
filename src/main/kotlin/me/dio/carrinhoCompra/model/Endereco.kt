package me.dio.carrinhoCompra.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Embeddable
import javax.persistence.Table

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
@Embeddable
@Table(name = "endereco")
data class Endereco(

    private var cep: String? = null,
    private var complemento: String? = null
)
