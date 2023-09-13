package com.example.advise.care.backend.transformers;

import com.example.advise.care.backend.dtos.requests.PatientRequestDto;
import com.example.advise.care.backend.enums.Role;
import com.example.advise.care.backend.models.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PatientTransformer {

    public User patientRequestDtoToUserEntity(PatientRequestDto patientRequestDto) {
        return User.builder()
                .name(patientRequestDto.getName())
                .age(patientRequestDto.getAge())
                .email(patientRequestDto.getEmail())
                .profilePictureUrl(patientRequestDto.getProfilePictureUrl())
                .role(Role.PATIENT)
                .build();
    }
}
