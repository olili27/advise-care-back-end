package com.example.advise.care.backend.dtos.responses.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserLoginResponseDto {

    String emailId;

    String password;

    String gender;
}
