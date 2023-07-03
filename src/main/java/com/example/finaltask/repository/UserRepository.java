package com.example.finaltask.repository;

import com.example.finaltask.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

//    User findByEmail();
    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String name);
}