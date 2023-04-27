package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.DTOs.requests.patient.PatientSignUpDto;
import com.example.advise.care.backend.DTOs.responses.patients.PatientSignUpResponseDto;
import com.example.advise.care.backend.DTOs.responses.user.UserLoginResponseDto;

public interface PatientService {
    public PatientSignUpResponseDto patientSignUp(PatientSignUpDto patientSignUpDto) throws Exception;

    public UserLoginResponseDto findPatientByEmailId(String emailId) throws Exception;

    public boolean loginUser(String emailId, String password) throws Exception;
}
