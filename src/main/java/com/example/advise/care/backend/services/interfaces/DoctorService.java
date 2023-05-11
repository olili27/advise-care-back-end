package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.dtos.requests.DoctorSignupDto;
import com.example.advise.care.backend.dtos.responses.doctors.DoctorSignUpResponseDto;
import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface DoctorService {

    public DoctorSignUpResponseDto doctorSignUp(DoctorSignupDto doctorSignupDto);
}
