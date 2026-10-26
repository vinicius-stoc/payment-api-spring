package com.viniciusstoc.paymentapispring.paymentDTO.response;

import java.time.LocalDateTime;


public record PaymentResponseDTO (
        String idPagamento,
        String statusPagamento,
        LocalDateTime processDate
        ){}
