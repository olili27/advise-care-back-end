package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.dtos.requests.PatientSignUpDto;
import com.example.advise.care.backend.dtos.responses.patients.PatientSignUpResponseDto;
import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;

import java.util.List;

public interface PatientService {
    public PatientSignUpResponseDto patientSignUp(PatientSignUpDto patientSignUpDto) throws Exception;

    public List<UserLoginResponseDto> getAllPatients();
}
