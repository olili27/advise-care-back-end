package com.example.advise.care.backend.controllers;

import com.example.advise.care.backend.exceptions.EmailIdNotFoundException;
import com.example.advise.care.backend.services.interfaces.DoctorService;
import com.example.advise.care.backend.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    DoctorService doctorService;

    @GetMapping("/login")
    public ResponseEntity userLogin(@RequestParam("emailId") String emailId, @RequestParam("password") String password) throws Exception {

        try {
            if(patientService.isPatientPresent(emailId)) {
                boolean canPatientLogin = patientService.loginPatient(emailId, password);

                return new ResponseEntity<>(canPatientLogin, HttpStatus.OK);
            }
            else if(doctorService.isDoctorPresent(emailId)) {
                boolean canDoctorLogin = doctorService.loginDoctor(emailId, password);

                return new ResponseEntity<>(canDoctorLogin, HttpStatus.OK);
            } else {
                throw new EmailIdNotFoundException("Email not found");
            }
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
