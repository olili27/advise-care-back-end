package com.example.advise.care.backend.controllers;

import com.example.advise.care.backend.dtos.requests.post.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @PostMapping("/{id}/post/create")
    public ResponseEntity<?> createPost(@PathVariable("id") int id, @RequestBody PostDto postRequestDto) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
