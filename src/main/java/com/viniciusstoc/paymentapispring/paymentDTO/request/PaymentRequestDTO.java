package com.viniciusstoc.paymentapispring.paymentDTO.request;


import jakarta.validation.constraints.*;
import java.math.BigDecimal;


public record PaymentRequestDTO (
        @NotBlank(message = "O nome é Obrigatório")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email com formato invalido")
        String email,

        @Positive(message = "O valor deve ser maior que 0")
        BigDecimal valorPagamento,

        @NotBlank(message = "É necessario informar o metódo de pagamento")
        String metodoPagamento,

        @Size(min = 13, max = 19, message = "Digite um nmero de cartão valido")
        String numeroCartao,

        @Size(min = 3, max = 3, message = "Digite um CVV valido")
        String codigoCartao
        ){}
