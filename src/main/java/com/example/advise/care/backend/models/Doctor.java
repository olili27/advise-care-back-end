package com.example.advise.care.backend.models;

import com.example.advise.care.backend.enums.Expertise;
import com.example.advise.care.backend.enums.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    String email;
    Integer age;
    String password;

    @Enumerated(EnumType.STRING)
    Expertise expertise;

    @Enumerated(EnumType.STRING)
    Role role;
}
