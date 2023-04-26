package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.DTOs.requests.patient.PatientSignUpDto;

public interface PatientService {
    public String patientSignUp(PatientSignUpDto patientSignUpDto) throws Exception;
}
