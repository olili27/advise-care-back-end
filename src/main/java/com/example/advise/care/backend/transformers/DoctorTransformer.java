package com.example.advise.care.backend.transformers;

import com.example.advise.care.backend.DTOs.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.models.Doctor;
import com.example.advise.care.backend.models.Patient;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DoctorTransformer {

    public static UserLoginResponseDto doctorEntityToUserLoginResponseDto(Doctor doctor) {
        return UserLoginResponseDto.builder()
                .emailId(doctor.getEmailId())
                .password(doctor.getPassword())
                .build();
    }
}
