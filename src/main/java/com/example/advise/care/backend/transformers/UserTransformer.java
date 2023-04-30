package com.example.advise.care.backend.transformers;

import com.example.advise.care.backend.dtos.requests.PatientSignUpDto;
import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.models.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTransformer {

    public static UserLoginResponseDto userEntityToUserLoginResponseDto(User user) {
        return UserLoginResponseDto.builder()
                .emailId(user.getEmailId())
                .gender(user.getGender())
                .build();
    }

    public User patientSignUpDtoToUserEntity(PatientSignUpDto patientSignUpDto) {
        return User.builder()
                .emailId(patientSignUpDto.getEmailId())
                .password(patientSignUpDto.getPassword())
                .build();
    }
}
