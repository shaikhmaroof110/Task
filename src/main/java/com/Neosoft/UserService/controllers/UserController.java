package com.Neosoft.UserService.controllers;

import com.Neosoft.UserService.entities.User;
import com.Neosoft.UserService.exception.ResourceNotFoundException;
import com.Neosoft.UserService.externals.services.PaymentService;
import com.Neosoft.UserService.services.UserService;
import com.Neosoft.paymentService.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    // create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1 = userService.saveUser(user);
        // code for created 201
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    // Payment service operation.
    // Endpoint to Create Payment for a User
    @PostMapping("/{userId}/payments")
    public ResponseEntity<Payment> createPayment(@PathVariable String userId, @RequestBody Payment payment) {
        // Call UserService which internally calls PaymentService (Feign Client)
        Payment createdPayment = userService.createPaymentForUser(payment);
        return ResponseEntity.ok(createdPayment);
    }

    // Endpoint to Update Payment for a User
    @PutMapping("/{userId}/payments/{paymentId}")
    public ResponseEntity<Payment> updatePayment(
            @PathVariable String userId,
            @PathVariable String paymentId,
            @RequestBody Payment payment) {
        Payment updatedPayment = userService.updateUserPayment(paymentId, payment);
        return ResponseEntity.ok(updatedPayment);
    }

    // Endpoint to Delete Payment for a User
    @DeleteMapping("/{userId}/payments/{paymentId}")
    public ResponseEntity<String> deletePayment(@PathVariable String userId, @PathVariable String paymentId) {
        userService.deleteUserPayment(paymentId);
        return ResponseEntity.ok("Payment deleted successfully.");
    }


    // single User get
    // we want to make userId globally
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId)
    {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // all user get
    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> allUser = userService.getAllUser();

        return ResponseEntity.ok(allUser);
    }

}