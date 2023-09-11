package com.example.advise.care.backend.models;

import com.example.advise.care.backend.enums.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    String email;
    Integer age;
    String password;
    String profilePictureUrl;

    @Enumerated(EnumType.STRING)
    Role role;
}
