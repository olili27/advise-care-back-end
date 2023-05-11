package com.example.advise.care.backend.dtos.responses.doctors;

import com.example.advise.care.backend.enums.DoctorSpeciality;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorSignUpResponseDto {

    String firstName;

    String lastName;

    DoctorSpeciality doctorSpeciality;

    String emailId;
}
