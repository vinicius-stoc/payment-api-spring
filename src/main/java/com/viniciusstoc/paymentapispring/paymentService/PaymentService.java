package com.viniciusstoc.paymentapispring.paymentService;

import com.viniciusstoc.paymentapispring.paymentDTO.request.PaymentRequestDTO;
import com.viniciusstoc.paymentapispring.paymentDTO.response.PaymentResponseDTO;
import com.viniciusstoc.paymentapispring.paymentEntity.PaymentEntity;
import com.viniciusstoc.paymentapispring.paymentRepository.PaymentRepository;
import com.viniciusstoc.paymentapispring.paymentUtils.PaymentConverter;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    public PaymentService(PaymentRepository paymentRepository) {this.paymentRepository = paymentRepository;}

    // cria
    public PaymentResponseDTO create(@Valid PaymentRequestDTO paymentRequestDTO) {
        PaymentEntity paymentEntity = PaymentConverter.toEntity(paymentRequestDTO);
        PaymentEntity savedEntity = paymentRepository.save(paymentEntity);
        return PaymentConverter.toResponse(savedEntity);
    }

    // Lista todos ou filtra por status
    public List<PaymentResponseDTO> findAll(Boolean status) {
        List<PaymentEntity> payments = (status == null)
                ? paymentRepository.findAll()
                : paymentRepository.findByStatusPagamento(status);
        return PaymentConverter.toResponseList(payments);
    }

    // Update
    public PaymentResponseDTO update(String id, PaymentRequestDTO paymentRequestDTO) {
        PaymentEntity paymentEntity = PaymentConverter.toEntity(paymentRequestDTO);
        paymentEntity.setIdPagamento(paymentEntity.getIdPagamento());
        return PaymentConverter.toResponse(paymentRepository.save(paymentEntity));
    }

    // Deleta
    public void delete(String id) {
        paymentRepository.deleteById(id);
    }

}
