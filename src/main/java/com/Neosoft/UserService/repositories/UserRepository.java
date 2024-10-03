package com.Neosoft.UserService.repositories;

import com.Neosoft.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends  JpaRepository<User, String>
{

}
