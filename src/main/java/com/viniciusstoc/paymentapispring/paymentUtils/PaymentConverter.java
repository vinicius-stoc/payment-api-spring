package com.viniciusstoc.paymentapispring.paymentUtils;

import com.viniciusstoc.paymentapispring.paymentDTO.request.PaymentRequestDTO;
import com.viniciusstoc.paymentapispring.paymentDTO.response.PaymentResponseDTO;
import com.viniciusstoc.paymentapispring.paymentEntity.PaymentEntity;

import java.util.List;

public class PaymentConverter {

    // Request -> Entity
    public static PaymentEntity toEntity(PaymentRequestDTO paymentRequestDTO) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setNome(paymentRequestDTO.nome());
        paymentEntity.setEmail(paymentRequestDTO.email());
        paymentEntity.setValorPagamento(paymentRequestDTO.valorPagamento());
        paymentEntity.setMetodoPagamento(paymentRequestDTO.metodoPagamento());
        paymentEntity.setNumeroCartao(paymentRequestDTO.numeroCartao());
        paymentEntity.setCodigoCartao(paymentRequestDTO.codigoCartao());
        return paymentEntity;
    }

    // Entity -> Response
    public static PaymentResponseDTO toResponse(PaymentEntity paymentEntity) {
        String statusFormatado = (paymentEntity.getStatusPagamento() != null && paymentEntity.getStatusPagamento())
                ? "APROVADO" : "NEGADO";

        return new PaymentResponseDTO(
                paymentEntity.getIdPagamento(),
                statusFormatado,
                paymentEntity.getProcessDate()
        );
    }


    // List Response
    public static List<PaymentResponseDTO> toResponseList(List<PaymentEntity> paymentEntityList) {
        if (paymentEntityList == null || paymentEntityList.isEmpty()) {
            return List.of();
        }
        return paymentEntityList.stream()
                .map(PaymentConverter::toResponse)
                .toList();
    }
}