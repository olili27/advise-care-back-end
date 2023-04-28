package com.example.advise.care.backend.repositories;

import com.example.advise.care.backend.models.PostView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostViewRepository extends JpaRepository<PostView, Integer> {
}
