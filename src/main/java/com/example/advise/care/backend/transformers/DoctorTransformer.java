package com.example.advise.care.backend.transformers;

import com.example.advise.care.backend.dtos.requests.DoctorSignupDto;
import com.example.advise.care.backend.dtos.responses.doctors.DoctorSignUpResponseDto;
import com.example.advise.care.backend.models.Doctor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DoctorTransformer {
    public Doctor doctorSignUpRequestDtoToDoctorEntity(DoctorSignupDto doctorSignupDto) {

     Doctor doctor = new Doctor();

     doctor.setFirstName(doctorSignupDto.getFirstName());
     doctor.setLastName(doctorSignupDto.getLastName());
     doctor.setDoctorSpeciality(doctorSignupDto.getDoctorSpeciality());
     doctor.setEmailId(doctorSignupDto.getEmailId());
     doctor.setPassword(doctorSignupDto.getPassword());
     doctor.setContactNumber(doctor.getContactNumber());

     return doctor;
    }

    public DoctorSignUpResponseDto doctorToDoctorSignUpResponseDto(Doctor doctor) {
        return DoctorSignUpResponseDto.builder()
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .doctorSpeciality(doctor.getDoctorSpeciality())
                .emailId(doctor.getEmailId())
                .build();
    }

}
