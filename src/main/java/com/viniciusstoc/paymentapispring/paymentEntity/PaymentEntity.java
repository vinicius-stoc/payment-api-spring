package com.viniciusstoc.paymentapispring.paymentEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@jakarta.persistence.Entity
@Data
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idPagamento;

    @Column
    private String nome;

    @Column
    @Email
    private String email;

    @Column
    private BigDecimal valorPagamento;

    @Column
    private String metodoPagamento;

    @Column
    private String numeroCartao;

    @Column
    private String codigoCartao;


    @Column
    private Boolean statusPagamento;

    @CreationTimestamp
    @Column(updatable = false)
    LocalDateTime processDate;

}
