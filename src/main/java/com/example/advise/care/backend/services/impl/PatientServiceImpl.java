package com.example.advise.care.backend.services.impl;

import com.example.advise.care.backend.dtos.requests.PatientRequestDto;
import com.example.advise.care.backend.dtos.responses.UserRegisterLoginResponseDto;
import com.example.advise.care.backend.enums.Role;
import com.example.advise.care.backend.models.Patient;
import com.example.advise.care.backend.repositories.PatientRepository;
import com.example.advise.care.backend.services.JwtService;
import com.example.advise.care.backend.services.interfaces.PatientService;
import com.example.advise.care.backend.transformers.PatientTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PasswordEncoder passwordEncoder;
    private final PatientRepository patientRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserRegisterLoginResponseDto registerPatient(PatientRequestDto patientRequestDto) {
        Patient patient = PatientTransformer.patientRequestDtoToPatientEntity(patientRequestDto);
        patient.setPassword(passwordEncoder.encode(patientRequestDto.getPassword()));

        Patient savedPatient = patientRepository.save(patient);
        String token = jwtService.generateToken(savedPatient);

        return UserRegisterLoginResponseDto.builder()
                .token(token)
                .build();
    }
}
