package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;

public interface DoctorService {
    public UserLoginResponseDto findDoctorByEmailId(String emailId) throws Exception;

    public boolean loginDoctor(String emailId, String password) throws Exception;

    public boolean isDoctorPresent(String emailId) throws Exception;
}
