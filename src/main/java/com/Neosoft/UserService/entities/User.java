package com.Neosoft.UserService.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
//    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer userId;
    private LocalDate date;
    private  String userName;
    private String userEmail;
    @Column(name ="MobileNumer", length = 10)
    private String userNumber;

 // user based on userName
    // we want to know user orders.
    // we don't want to store in database so we are using @Transient. JPA will ignore it.
    @Transient
    private List<Orders> orders = new ArrayList<>();
}
