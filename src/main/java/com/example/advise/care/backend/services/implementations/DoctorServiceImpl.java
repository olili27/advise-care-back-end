package com.example.advise.care.backend.services.implementations;

import com.example.advise.care.backend.DTOs.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.exceptions.EmailIdNotFoundException;
import com.example.advise.care.backend.exceptions.WrongPasswordException;
import com.example.advise.care.backend.models.Doctor;
import com.example.advise.care.backend.models.Patient;
import com.example.advise.care.backend.repositories.DoctorRepository;
import com.example.advise.care.backend.services.interfaces.DoctorService;
import com.example.advise.care.backend.transformers.DoctorTransformer;
import com.example.advise.care.backend.transformers.PatientTransformer;
import com.example.advise.care.backend.utilities.UserValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public UserLoginResponseDto findDoctorByEmailId(String emailId) throws Exception {

        try {
            Doctor doctor = doctorRepository.findByEmailId(emailId);

            return DoctorTransformer.doctorEntityToUserLoginResponseDto(doctor);
        } catch (Exception e) {
            throw new EmailIdNotFoundException("Email not found");
        }

    }

    @Override
    public boolean loginDoctor(String emailId, String password) throws Exception {

        try {
            UserLoginResponseDto userLoginResponseDto = findDoctorByEmailId(emailId);

            return UserValidatorUtil.validateUserPassword(password, userLoginResponseDto.getPassword());
        } catch (EmailIdNotFoundException e) {
            throw new EmailIdNotFoundException("Email not found");
        }
        catch (WrongPasswordException e) {
            throw new WrongPasswordException("Password is incorrect");
        }
    }

    @Override
    public boolean isDoctorPresent(String emailId) throws Exception {

       return doctorRepository.findByEmailId(emailId) == null;
    }
}
