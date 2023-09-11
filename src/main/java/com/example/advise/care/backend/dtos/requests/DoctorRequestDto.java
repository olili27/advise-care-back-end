package com.example.advise.care.backend.dtos.requests;

import com.example.advise.care.backend.enums.Expertise;

public class DoctorRequestDto {
    String name;
    String email;
    Integer age;
    String password;
    String profilePictureUrl;
    Expertise expertise;
}
