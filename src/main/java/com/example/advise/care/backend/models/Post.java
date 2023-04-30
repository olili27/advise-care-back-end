package com.example.advise.care.backend.models;

import jakarta.persistence.*;
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
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, length = 10000)
    String title;

    @Column(nullable = false)
    String body;

    String imageUrl;

    @CreationTimestamp
    Date createdAt;

    @ManyToOne
    @JoinColumn
    Doctor author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<PostView> postViewList = new ArrayList<>();
}
