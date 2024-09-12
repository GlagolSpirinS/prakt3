package com.example.project2.repository;

import com.example.project2.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUsername(String username);

    UserModel findByUsernameAndPassword(String username, String password);
}