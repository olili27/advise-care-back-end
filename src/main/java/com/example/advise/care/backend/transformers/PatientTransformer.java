package com.example.advise.care.backend.transformers;

import com.example.advise.care.backend.dtos.requests.PatientRequestDto;
import com.example.advise.care.backend.enums.Role;
import com.example.advise.care.backend.models.Patient;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PatientTransformer {

    public Patient patientRequestDtoToPatientEntity(PatientRequestDto patientRequestDto) {
        return Patient.builder()
                .name(patientRequestDto.getName())
                .age(patientRequestDto.getAge())
                .email(patientRequestDto.getEmail())
                .profilePictureUrl(patientRequestDto.getProfilePictureUrl())
                .role(Role.PATIENT)
                .build();
    }
}
