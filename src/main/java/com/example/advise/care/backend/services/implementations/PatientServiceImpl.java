package com.example.advise.care.backend.services.implementations;

import com.example.advise.care.backend.dtos.requests.PatientSignUpDto;
import com.example.advise.care.backend.dtos.responses.patients.PatientSignUpResponseDto;
import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.exceptions.*;
import com.example.advise.care.backend.models.Patient;
import com.example.advise.care.backend.models.User;
import com.example.advise.care.backend.repositories.PatientRepository;
import com.example.advise.care.backend.services.interfaces.PatientService;
import com.example.advise.care.backend.transformers.UserTransformer;
import com.example.advise.care.backend.utilities.UserValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

            Patient patientCheck = patientRepository.findByEmailId(patientSignUpDto.getEmailId());

            if(patientCheck != null) throw new DuplicateEmailException("Email already exits");

            UserValidatorUtil.confirmPassword(patientSignUpDto.getPassword(), patientSignUpDto.getConfirmPassword());

            UserValidatorUtil.validatePasswordLength(patientSignUpDto.getPassword());

            User user = UserTransformer.patientSignUpDtoToUserEntity(patientSignUpDto);

            Patient patient = new Patient();
            patient.setId(user.getId());
            patient.setEmailId(user.getEmailId());
            patient.setPassword(user.getPassword());

            Patient savedPatient = patientRepository.save(patient);

            return PatientSignUpResponseDto.builder().emailId(savedPatient.getEmailId()).build();
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
        catch(DuplicateEmailException e) {
            throw new DuplicateEmailException("Email already exits");
        }
    }

    @Override
    public List<UserLoginResponseDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<UserLoginResponseDto> patientsDtos = new ArrayList<>();

        for(Patient patient: patients) {
            patientsDtos.add(UserTransformer.userEntityToUserLoginResponseDto(patient));
        }

        return patientsDtos;
    }

    /*
    TODO
    1. handle exceptions
    2. validate if email is valid
     */

}
