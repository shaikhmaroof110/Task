package com.Neosoft.UserService.services;

import com.Neosoft.UserService.entities.User;
import com.Neosoft.paymentService.entities.Payment;

import java.util.List;

public interface UserService {

    // create user
    User saveUser(User user);

    // get All User
    List<User> getAllUser();

    // get UserById
    User  getUser(String userId);


    // feign impl
    Payment createPaymentForUser(Payment payment);

    void deleteUserPayment(String paymentId);

    Payment updateUserPayment(String paymentId, Payment payment);
}
