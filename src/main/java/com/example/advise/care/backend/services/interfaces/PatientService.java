package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.dtos.requests.PatientSignUpDto;
import com.example.advise.care.backend.dtos.responses.patients.PatientSignUpResponseDto;

public interface PatientService {
    public PatientSignUpResponseDto patientSignUp(PatientSignUpDto patientSignUpDto) throws Exception;
}
