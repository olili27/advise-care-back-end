package com.example.advise.care.backend.transformers;

import com.example.advise.care.backend.DTOs.requests.patient.PatientSignUpDto;
import com.example.advise.care.backend.DTOs.responses.patients.PatientSignUpResponseDto;
import com.example.advise.care.backend.DTOs.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.models.Patient;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PatientTransformer {

    public static PatientSignUpResponseDto patientEntityToPatientSignUpResponseDto(Patient patient) {
        return PatientSignUpResponseDto.builder()
                .username(patient.getUsername())
                .build();
    }

    public static Patient patientSignUpDtoToPatientEntity(PatientSignUpDto patientSignUpDto) {
        return Patient.builder()
                .emailId(patientSignUpDto.getEmailId())
                .password(patientSignUpDto.getPassword())
                .build();
    }

    public static UserLoginResponseDto patientEntityToUserLoginResponseDto(Patient patient) {
        return UserLoginResponseDto.builder()
                .emailId(patient.getEmailId())
                .password(patient.getPassword())
                .build();
    }
}
