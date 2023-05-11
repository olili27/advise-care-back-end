package com.example.advise.care.backend.dtos.requests;

import com.example.advise.care.backend.enums.DoctorSpeciality;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorSignupDto {

    String firstName;

    String lastName;

    DoctorSpeciality doctorSpeciality;

    String emailId;

    String password;

    String contactNumber;
}
