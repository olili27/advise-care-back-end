package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.dtos.requests.UserLoginRequestDto;
import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;

public interface UserService {
    public UserLoginResponseDto userLogin(UserLoginRequestDto userLoginRequestDto) throws Exception;
    public String userForgotPassword(String emailId) throws Exception;

    public String resetUserPassword(String id, String newPassword) throws Exception;
}
