package com.example.advise.care.backend.controllers;

import com.example.advise.care.backend.dtos.requests.post.PostRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @PostMapping("/{id}/create-post")
    public ResponseEntity<?> createPost(@PathVariable("id") int id, @RequestBody PostRequestDto postRequestDto) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
