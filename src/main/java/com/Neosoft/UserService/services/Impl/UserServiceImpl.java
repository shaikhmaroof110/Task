package com.Neosoft.UserService.services.Impl;

import com.Neosoft.UserService.entities.Orders;
import com.Neosoft.UserService.entities.User;
import com.Neosoft.UserService.exception.ResourceNotFoundException;
import com.Neosoft.UserService.externals.services.OrderService;
import com.Neosoft.UserService.externals.services.PaymentService;
import com.Neosoft.UserService.repositories.UserRepository;
import com.Neosoft.UserService.services.UserService;
import com.Neosoft.paymentService.entities.Payment;
import jakarta.persistence.criteria.Order;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

// ALt + Enter to get all unimplemented methods.

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Feign Client
    @Autowired
    private OrderService orderService;


    @Override
    public User getUser(String userId) {
        //get user from database with the help  of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        return user;
    }

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(Integer.valueOf(randomUserId));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    // feign client communication.

    @Autowired
    private PaymentService paymentService;

    //  Create Payment for User
    public Payment createPaymentForUser(Payment payment) {
        // Call the Payment Service to create a payment
        return paymentService.createPayment(payment);
    }

    //  Update Payment for User
    public Payment updateUserPayment(String paymentId, Payment payment) {
        // Call the Payment Service to update the payment
        return paymentService.updatePayment(paymentId, payment);
    }

    // Delete Payment for User
    public void deleteUserPayment(String paymentId) {
        // Call the Payment Service to delete the payment
        paymentService.deletePayment(paymentId);
    }
}
