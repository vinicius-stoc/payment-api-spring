package com.viniciusstoc.paymentapispring.paymentRepository;

import com.viniciusstoc.paymentapispring.paymentEntity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, String> {

    List<PaymentEntity> findByStatusPagamento(Boolean statusPagamento);

}
