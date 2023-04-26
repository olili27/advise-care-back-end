package com.example.advise.care.backend.transformers;

import com.example.advise.care.backend.DTOs.responses.patients.PatientSignUpResponseDto;
import com.example.advise.care.backend.models.Patient;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PatientTransformer {

    public static PatientSignUpResponseDto patientEntityToDto(Patient patient) {
        return PatientSignUpResponseDto.builder().username(patient.getUsername()).build();
    }
}
