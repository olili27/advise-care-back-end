package com.example.advise.care.backend.controllers;

import com.example.advise.care.backend.dtos.requests.PatientSignUpDto;
import com.example.advise.care.backend.dtos.responses.patients.PatientSignUpResponseDto;
import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.services.interfaces.PatientService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    /*
    TODO
    validate email -> ensure it is a right email
     */

    @Autowired
    PatientService patientService;

    @PostMapping("/signup")
    public ResponseEntity<?> patientSignup(@Valid  @RequestBody PatientSignUpDto patientSignUpDto) throws Exception {

       try{
           PatientSignUpResponseDto patientSignUpResponseDto = patientService.patientSignUp(patientSignUpDto);

           return new ResponseEntity<>(patientSignUpResponseDto, HttpStatus.CREATED);
       }
       catch (ConstraintViolationException e) {
           return new ResponseEntity<>("Email should be valid", HttpStatus.BAD_REQUEST);
       }
       catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       }

    }

    @GetMapping("/get-all")
    public List<UserLoginResponseDto> getAllPatients() {
        return patientService.getAllPatients();
    }
}
