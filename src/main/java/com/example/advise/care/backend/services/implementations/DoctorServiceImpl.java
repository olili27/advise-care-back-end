package com.example.advise.care.backend.services.implementations;

import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.exceptions.EmailIdNotFoundException;
import com.example.advise.care.backend.exceptions.WrongPasswordException;
import com.example.advise.care.backend.models.Doctor;
import com.example.advise.care.backend.repositories.DoctorRepository;
import com.example.advise.care.backend.services.interfaces.DoctorService;
import com.example.advise.care.backend.transformers.DoctorTransformer;
import com.example.advise.care.backend.utilities.UserValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class DoctorServiceImpl implements DoctorService {

}
