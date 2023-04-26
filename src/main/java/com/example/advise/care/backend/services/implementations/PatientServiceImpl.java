package com.example.advise.care.backend.services.implementations;

import com.example.advise.care.backend.DTOs.requests.patient.PatientSignUpDto;
import com.example.advise.care.backend.DTOs.responses.patients.PatientSignUpResponseDto;
import com.example.advise.care.backend.exceptions.*;
import com.example.advise.care.backend.models.Patient;
import com.example.advise.care.backend.repositories.PatientRepository;
import com.example.advise.care.backend.services.interfaces.PatientService;
import com.example.advise.care.backend.utilities.PatientValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public String patientSignUp(PatientSignUpDto patientSignUpDto) throws Exception {
        try{
            PatientValidatorUtil.validatePatientSignUpDto(patientSignUpDto);

            PatientValidatorUtil.confirmPassword(patientSignUpDto.getPassword(), patientSignUpDto.getConfirmPassword());

            PatientValidatorUtil.validatePasswordLength(patientSignUpDto.getPassword());

            Patient patient = Patient.builder()
                    .emailId(patientSignUpDto.getEmailId())
                    .password(patientSignUpDto.getPassword())
                    .build();

            Patient savedPatient = patientRepository.save(patient);

            return PatientSignUpResponseDto.builder().username(savedPatient.getUsername()).build().getUsername();
        }
        catch (MissingPasswordException | MissingPasswordConfirmationException | MissingEmailException | InvalidPasswordLengthException e) {
           return e.getMessage();
        }
    }
}
