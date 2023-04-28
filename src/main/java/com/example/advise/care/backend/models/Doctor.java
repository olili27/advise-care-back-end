package com.example.advise.care.backend.models;

import com.example.advise.care.backend.enums.DoctorSpeciality;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DiscriminatorValue("doctor")
@Table(name = "doctors")
public class Doctor extends User {

    String firstName;

    String lastName;

    @Enumerated(EnumType.STRING)
    DoctorSpeciality doctorSpeciality;

    String contactNumber;

    @ManyToMany
    @JoinColumn
    List<Patient> patients = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Post> posts = new ArrayList<>();
}
