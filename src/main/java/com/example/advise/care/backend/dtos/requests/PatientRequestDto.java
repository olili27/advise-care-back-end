package com.example.advise.care.backend.dtos.requests;

import lombok.Data;

@Data
public class PatientRequestDto {
    String name;
    String email;
    Integer age;
    String password;
    String profilePictureUrl;
}
