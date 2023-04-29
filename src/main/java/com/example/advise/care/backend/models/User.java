package com.example.advise.care.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String gender;

    @Column(unique = true)
    @Email(message = "Email should be valid")
    String emailId;

    String password;

    String imageUrl;

    @CreationTimestamp
    Date joinedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<PostView> postViews = new ArrayList<>();
}


/*
TODO

create the inheritance hierarchy

 */