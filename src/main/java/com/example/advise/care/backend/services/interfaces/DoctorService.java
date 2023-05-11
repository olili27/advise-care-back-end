package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.dtos.requests.DoctorSignupDto;
import com.example.advise.care.backend.dtos.responses.doctors.DoctorSignUpResponseDto;

import java.util.List;

public interface DoctorService {

    public DoctorSignUpResponseDto doctorSignUp(DoctorSignupDto doctorSignupDto);

    public List<DoctorSignUpResponseDto> getAllDoctors();
}
