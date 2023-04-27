package com.example.advise.care.backend.services.implementations;

import com.example.advise.care.backend.DTOs.requests.patient.PatientSignUpDto;
import com.example.advise.care.backend.DTOs.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.DTOs.responses.patients.PatientSignUpResponseDto;
import com.example.advise.care.backend.exceptions.*;
import com.example.advise.care.backend.models.Patient;
import com.example.advise.care.backend.repositories.PatientRepository;
import com.example.advise.care.backend.services.interfaces.PatientService;
import com.example.advise.care.backend.transformers.PatientTransformer;
import com.example.advise.care.backend.utilities.UserValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    /*
   TODO
   1. validate if email is valid
    */
    @Override
    public PatientSignUpResponseDto patientSignUp(PatientSignUpDto patientSignUpDto) throws Exception {
        try{
            UserValidatorUtil.validatePatientSignUpDto(patientSignUpDto);

            UserValidatorUtil.confirmPassword(patientSignUpDto.getPassword(), patientSignUpDto.getConfirmPassword());

            UserValidatorUtil.validatePasswordLength(patientSignUpDto.getPassword());

            Patient patient = PatientTransformer.patientSignUpDtoToPatientEntity(patientSignUpDto);

            Patient savedPatient = patientRepository.save(patient);

            return PatientTransformer.patientEntityToPatientSignUpResponseDto(savedPatient);
        }
        catch (MissingPasswordException e) {
            throw new MissingPasswordException("Password field is empty");
        }
        catch(MissingPasswordConfirmationException e) {
            throw new MissingPasswordConfirmationException("Confirm password field is empty");
        }
        catch (MissingEmailException e) {
            throw new MissingEmailException("Email field is empty");
        }
        catch(InvalidPasswordLengthException e) {
           throw new InvalidPasswordLengthException("The password should be of 8 or more characters");
        }
    }


    /*
    TODO
    1. handle exceptions
    2. validate if email is valid
     */
    @Override
    public UserLoginResponseDto findPatientByEmailId(String emailId) throws Exception {

        try {
            Patient patient = patientRepository.findByEmailId(emailId);

            return PatientTransformer.patientEntityToUserLoginResponseDto(patient);
        } catch (Exception e) {
            throw new EmailIdNotFoundException("Email not found");
        }

    }

    @Override
    public boolean loginPatient(String emailId, String password) throws Exception {

        try {
            UserLoginResponseDto userLoginResponseDto = findPatientByEmailId(emailId);

            return UserValidatorUtil.validateUserPassword(password, userLoginResponseDto.getPassword());

        } catch (EmailIdNotFoundException e) {
            throw new EmailIdNotFoundException("Email not found");
        }
        catch (WrongPasswordException e) {
            throw new WrongPasswordException("Password is incorrect");
        }
    }

    @Override
    public boolean isPatientPresent(String emailId) {

        return patientRepository.findByEmailId(emailId) == null;
    }
}
