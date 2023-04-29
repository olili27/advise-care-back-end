package com.example.advise.care.backend.controllers;

import com.example.advise.care.backend.dtos.requests.UserLoginRequestDto;
import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.services.interfaces.UserService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> userLogin(@Valid @RequestBody UserLoginRequestDto userLoginRequestDto) throws Exception {

        try {
            UserLoginResponseDto userLoginResponseDto = userService.userLogin(userLoginRequestDto);

            return new ResponseEntity<>(userLoginResponseDto, HttpStatus.OK);
        }
        catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Email should be valid", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/forgot-password")
    public ResponseEntity<?> userForgotPassword(@Valid @RequestParam("emailId") String emailId) throws Exception {

        try {
            String success = userService.userForgotPassword(emailId);

            return new ResponseEntity<>(success, HttpStatus.OK);
        }
        catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Email should be valid", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/forgot-password/{id}/reset/{resetToken}")
    public ResponseEntity<?> resetUserPassword(@PathVariable("id") String id, @RequestParam("newPassword") String newPassword, @PathVariable("resetToken") String resetToken) throws Exception {

        try {
            String success = userService.resetUserPassword(id, newPassword, resetToken);

            return new ResponseEntity<>(success, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
