package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.dtos.requests.patient.PatientSignUpDto;
import com.example.advise.care.backend.dtos.responses.patients.PatientSignUpResponseDto;
import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;

public interface PatientService {
    public PatientSignUpResponseDto patientSignUp(PatientSignUpDto patientSignUpDto) throws Exception;
}
