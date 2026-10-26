package com.viniciusstoc.paymentapispring.paymentController;


import com.viniciusstoc.paymentapispring.paymentDTO.request.PaymentRequestDTO;
import com.viniciusstoc.paymentapispring.paymentDTO.response.PaymentResponseDTO;
import com.viniciusstoc.paymentapispring.paymentService.PaymentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/device-payments")
public class PaymentController {

    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("payments")
    public PaymentResponseDTO createPayment(@Valid @RequestBody PaymentRequestDTO paymentRequestDTO) {
       return paymentService.create(paymentRequestDTO);
    }


    @GetMapping("payments")
    public List<PaymentResponseDTO> getPayments(@Valid
            @RequestParam(required = false) Boolean status){
        return paymentService.findAll (status);
    }


    @PutMapping("payments/{id}")
    public PaymentResponseDTO updatePayment(@Valid @PathVariable String id, @RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentService.update(id, paymentRequestDTO);
    }


    @DeleteMapping("payments/{id}")
    public void deletePayment(@Valid @PathVariable String id){
         paymentService.delete(id);
    }

}
