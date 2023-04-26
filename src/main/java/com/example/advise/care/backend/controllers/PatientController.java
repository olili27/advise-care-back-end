package com.example.advise.care.backend.controllers;

import com.example.advise.care.backend.DTOs.requests.patient.PatientSignUpDto;
import com.example.advise.care.backend.DTOs.responses.patients.PatientSignUpResponseDto;
import com.example.advise.care.backend.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/patient-signup")
    public ResponseEntity patientSignup(@RequestBody PatientSignUpDto patientSignUpDto) throws Exception {

       try{
           String patientName = patientService.patientSignUp(patientSignUpDto);

           return new ResponseEntity<>(patientName, HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }

    }
}
