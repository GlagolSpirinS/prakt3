package com.example.project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project2.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsernameAndPassword(String username, String password);
}
