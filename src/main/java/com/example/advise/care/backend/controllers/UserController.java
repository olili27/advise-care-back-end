package com.example.advise.care.backend.controllers;

import com.example.advise.care.backend.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    PatientService patientService;

    @GetMapping("/login")
    public ResponseEntity userLogin(@RequestParam("emailId") String emailId, @RequestParam("password") String password) {

        try {
                patientService
        }
    }
}
