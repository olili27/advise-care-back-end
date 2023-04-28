package com.example.advise.care.backend.dtos.responses.patients;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientSignUpResponseDto {

    String emailId;
}
