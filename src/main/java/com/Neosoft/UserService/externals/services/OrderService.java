package com.Neosoft.UserService.externals.services;

import jakarta.persistence.criteria.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORDER-SERVICE")
public interface OrderService {

    // in feign client we don't need to implementation.
//    get order by order id
    @GetMapping("/orders/{orderId}")
     Order getOrders(@PathVariable("orderId") String orderId);

}
