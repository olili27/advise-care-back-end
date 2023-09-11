package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.dtos.requests.PatientRequestDto;
import com.example.advise.care.backend.dtos.responses.UserRegisterLoginResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {
    UserRegisterLoginResponseDto registerPatient(PatientRequestDto patientRequestDto);
}
