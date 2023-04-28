package com.example.advise.care.backend.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DiscriminatorValue("patient")
@Table(name = "patients")
public class Patient extends User {

    int age;

    @ManyToMany(mappedBy = "patients", cascade = CascadeType.ALL)
    List<Doctor> doctors = new ArrayList<>();
}
