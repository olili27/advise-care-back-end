package com.example.advise.care.backend.controllers.authorization;

import com.example.advise.care.backend.dtos.requests.UserLoginDto;
import com.example.advise.care.backend.dtos.responses.UserRegisterLoginResponseDto;
import com.example.advise.care.backend.services.interfaces.DoctorService;
import com.example.advise.care.backend.services.interfaces.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authorization/login")
public class AuthorizationController {
    private final PatientService patientService;
    private final DoctorService doctorService;

    @PostMapping("/patient")
    public ResponseEntity<UserRegisterLoginResponseDto> loginPatient(@RequestBody UserLoginDto userLoginDto) {
        UserRegisterLoginResponseDto responseDto = patientService.loginPatient(userLoginDto);

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/doctor")
    public ResponseEntity<UserRegisterLoginResponseDto> loginDoctor(@RequestBody UserLoginDto userLoginDto) {
        UserRegisterLoginResponseDto responseDto = doctorService.loginDoctor(userLoginDto);

        return ResponseEntity.ok(responseDto);
    }
}
