package com.example.advise.care.backend.controllers;

import com.example.advise.care.backend.dtos.requests.UserLoginRequestDto;
import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.exceptions.EmailIdNotFoundException;
import com.example.advise.care.backend.services.interfaces.DoctorService;
import com.example.advise.care.backend.services.interfaces.PatientService;
import com.example.advise.care.backend.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserLoginRequestDto userLoginRequestDto) throws Exception {

        try {
            UserLoginResponseDto userLoginResponseDto = userService.userLogin(userLoginRequestDto);

            return new ResponseEntity<>(userLoginResponseDto, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/forgot-password")
    public ResponseEntity<?> userForgotPassword(@RequestParam("emailId") String emailId) throws Exception {

        try {
            String success = userService.userForgotPassword(emailId);

            return new ResponseEntity<>(success, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/forgot-password/{id}/reset")
    public ResponseEntity<?> resetUserPassword(@PathVariable("id") String id, @RequestParam("newPassword") String newPassword) throws Exception {

        try {
            String success = userService.resetUserPassword(id, newPassword);

            return new ResponseEntity<>(success, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
