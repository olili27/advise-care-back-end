package com.example.advise.care.backend.controllers.authentication;

import com.example.advise.care.backend.dtos.requests.PatientRequestDto;
import com.example.advise.care.backend.dtos.responses.UserRegisterLoginResponseDto;
import com.example.advise.care.backend.services.interfaces.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/register")
public class AuthenticationController {
    private final PatientService patientService;

    @PostMapping("/patient")
    public ResponseEntity<UserRegisterLoginResponseDto> registerPatient(@RequestBody PatientRequestDto patientRequestDto) {
        UserRegisterLoginResponseDto responseDto = patientService.registerPatient(patientRequestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
