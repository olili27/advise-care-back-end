package com.example.advise.care.backend.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
//    Content content;
    Integer numberOfViews;
    Integer numberOfLikes;
    Integer numberOfComments;

    @CreationTimestamp
    LocalDate dateOfCreation;
}
