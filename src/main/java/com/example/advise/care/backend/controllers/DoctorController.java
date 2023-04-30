package com.example.advise.care.backend.controllers;

import com.example.advise.care.backend.dtos.requests.PostRequestDto;
import com.example.advise.care.backend.dtos.responses.PostResponseDto;
import com.example.advise.care.backend.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    PostService postService;

    @PostMapping("/{doctorId}/post/create")
    public ResponseEntity<?> createPost(@PathVariable("doctorId") String doctorId, @RequestBody PostRequestDto postRequestDto) {

        try {
            PostResponseDto postResponseDto = postService.createPost(doctorId, postRequestDto);

            return new ResponseEntity<>(postResponseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{doctorId}/post/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable("doctorId") String doctorId, String postId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
