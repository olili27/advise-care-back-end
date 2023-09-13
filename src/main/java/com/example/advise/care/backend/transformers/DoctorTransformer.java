package com.example.advise.care.backend.transformers;

import com.example.advise.care.backend.dtos.requests.DoctorRequestDto;
import com.example.advise.care.backend.models.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DoctorTransformer {

    public User doctorRequestDtoToUserEntity(DoctorRequestDto doctorRequestDto) {
        return User.builder()
                .name(doctorRequestDto.getName())
                .email(doctorRequestDto.getEmail())
                .age(doctorRequestDto.getAge())
                .profilePictureUrl(doctorRequestDto.getProfilePictureUrl())
                .expertise(doctorRequestDto.getExpertise())
                .build();
    }
}
