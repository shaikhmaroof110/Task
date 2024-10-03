package com.Neosoft.UserService.externals.services;

import com.Neosoft.paymentService.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentService {


    // create Payment
    @PostMapping("/ratings")
    Payment createPayment(Payment values);

    // update
    @PutMapping("ratings/{paymentId}")
    Payment updatePayment(@PathVariable String paymentId, Payment payment);

    // Delete Payment
    @DeleteMapping("/payments/{paymentId}")
    void deletePayment(@PathVariable String paymentId);
}
