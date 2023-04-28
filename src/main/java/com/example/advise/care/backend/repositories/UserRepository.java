package com.example.advise.care.backend.repositories;

import com.example.advise.care.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmailId(String emailId);
}
