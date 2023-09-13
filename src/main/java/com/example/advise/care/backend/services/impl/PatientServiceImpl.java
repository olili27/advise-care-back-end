package com.example.advise.care.backend.services.impl;

import com.example.advise.care.backend.dtos.requests.PatientRequestDto;
import com.example.advise.care.backend.dtos.requests.UserLoginDto;
import com.example.advise.care.backend.dtos.responses.UserRegisterLoginResponseDto;
import com.example.advise.care.backend.models.User;
import com.example.advise.care.backend.repositories.UserRepository;
import com.example.advise.care.backend.services.JwtService;
import com.example.advise.care.backend.services.interfaces.PatientService;
import com.example.advise.care.backend.transformers.PatientTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserRegisterLoginResponseDto registerPatient(PatientRequestDto patientRequestDto) {
        User patient = PatientTransformer.patientRequestDtoToUserEntity(patientRequestDto);
        patient.setPassword(passwordEncoder.encode(patientRequestDto.getPassword()));

        User savedPatient = userRepository.save(patient);
        String token = jwtService.generateToken(savedPatient);

        return UserRegisterLoginResponseDto.builder()
                .token(token)
                .build();
    }

    @Override
    public UserRegisterLoginResponseDto loginPatient(UserLoginDto userLoginDto) {
        authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       userLoginDto.getEmail(),
                       userLoginDto.getPassword()
               )
        );

        var patient = userRepository.findByEmail(userLoginDto.getEmail()).orElseThrow();
        String token = jwtService.generateToken(patient);

        return UserRegisterLoginResponseDto.builder().token(token).build();
    }
}
