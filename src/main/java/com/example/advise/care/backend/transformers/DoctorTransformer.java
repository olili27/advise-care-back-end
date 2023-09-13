package com.example.advise.care.backend.transformers;

import com.example.advise.care.backend.dtos.requests.DoctorRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DoctorTransformer {

    public Doctor doctorRequestDtoToDoctorEntity(DoctorRequestDto doctorRequestDto) {
        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .email(doctorRequestDto.getEmail())
                .age(doctorRequestDto.getAge())
                .profilePictureUrl(doctorRequestDto.getProfilePictureUrl())
                .expertise(doctorRequestDto.getExpertise())
                .build();
    }
}
