package com.example.advise.care.backend.services.impl;

import com.example.advise.care.backend.dtos.requests.DoctorRequestDto;
import com.example.advise.care.backend.dtos.requests.UserLoginDto;
import com.example.advise.care.backend.dtos.responses.UserRegisterLoginResponseDto;
import com.example.advise.care.backend.models.Doctor;
import com.example.advise.care.backend.repositories.DoctorRepository;
import com.example.advise.care.backend.services.JwtService;
import com.example.advise.care.backend.services.interfaces.DoctorService;
import com.example.advise.care.backend.transformers.DoctorTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserRegisterLoginResponseDto registerDoctor(DoctorRequestDto doctorRequestDto) {
        Doctor doctor = DoctorTransformer.doctorRequestDtoToDoctorEntity(doctorRequestDto);
        doctor.setPassword(passwordEncoder.encode(doctorRequestDto.getPassword()));

        Doctor savedDoctor = doctorRepository.save(doctor);
        String token = jwtService.generateToken(savedDoctor);
        return UserRegisterLoginResponseDto.builder()
                .token(token)
                .build();
    }

    @Override
    public UserRegisterLoginResponseDto loginDoctor(UserLoginDto userLoginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDto.getEmail(),
                        userLoginDto.getPassword()
                )
        );

        var doctor = doctorRepository.findByEmail(userLoginDto.getEmail()).orElseThrow();
        String token = jwtService.generateToken(doctor);

        return UserRegisterLoginResponseDto.builder()
                .token(token)
                .build();
    }
}
