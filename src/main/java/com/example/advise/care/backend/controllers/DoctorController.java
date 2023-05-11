package com.example.advise.care.backend.controllers;

import com.example.advise.care.backend.dtos.requests.DoctorSignupDto;
import com.example.advise.care.backend.dtos.requests.PostRequestDto;
import com.example.advise.care.backend.dtos.responses.PostResponseDto;
import com.example.advise.care.backend.dtos.responses.doctors.DoctorSignUpResponseDto;
import com.example.advise.care.backend.services.interfaces.DoctorService;
import com.example.advise.care.backend.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    PostService postService;

    @Autowired
    DoctorService doctorService;

    @PostMapping("/signup")
    public ResponseEntity<?> doctorSignUp(@RequestBody DoctorSignupDto doctorSignupDto) {
        DoctorSignUpResponseDto doctorSignUpResponseDto = doctorService.doctorSignUp(doctorSignupDto);

        return new ResponseEntity<>(doctorSignUpResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/post/create")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDto postRequestDto) {

        try {
            PostResponseDto postResponseDto = postService.createPost(postRequestDto);

            return new ResponseEntity<>(postResponseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @GetMapping("/get-all")
    public List<DoctorSignUpResponseDto> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @DeleteMapping("/{doctorId}/post/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable("doctorId") String doctorId, String postId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
