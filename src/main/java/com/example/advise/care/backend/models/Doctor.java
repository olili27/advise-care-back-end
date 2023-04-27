package com.example.advise.care.backend.models;

import com.example.advise.care.backend.enums.DoctorSpeciality;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String firstName;

    String lastName;

    String emailId;

    String password;

    @Enumerated(EnumType.STRING)
    DoctorSpeciality doctorSpeciality;

    String imageUrl;

    @CreationTimestamp
    Date dateJoined;
}
