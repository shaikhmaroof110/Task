package com.Neosoft.UserService.entities;

import lombok.*;

import java.time.LocalDate;

// we are not creating it entity because we don't want to store it into database.
// we wil be calling it from Order service.

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {


    private String orderId;
    private String userId;
    private String status;
    private String orderNumber;
    private LocalDate orderDate;



}
