package com.example.advise.care.backend.utilities;

import com.example.advise.care.backend.dtos.requests.patient.PatientSignUpDto;
import com.example.advise.care.backend.exceptions.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserValidatorUtil {
    public static void validatePatientSignUpDto(PatientSignUpDto patientSignUpDto) throws Exception {
        if(patientSignUpDto.getEmailId().trim().equals("") || patientSignUpDto.getEmailId().equals(null)) {
            throw new MissingEmailException("Email field is empty");
        }

        if(patientSignUpDto.getPassword().trim().equals("") || patientSignUpDto.getPassword().equals(null)) {
            throw new MissingPasswordException("Password field is empty");
        }

        if(patientSignUpDto.getConfirmPassword().trim().equals("") || patientSignUpDto.getConfirmPassword().equals(null)) {
            throw new MissingPasswordConfirmationException("Confirm field is empty");
        }
    }

    public static void confirmPassword(String password, String confirmPassword ) throws NotMatchingPasswordsException {
        if(!password.trim().equals(confirmPassword.trim())) {
            throw new NotMatchingPasswordsException("Passwords not matching");
        }
    }

    public static void validatePasswordLength(String password) throws InvalidPasswordLengthException {
        if(password.trim().length() < 8) {
            throw new InvalidPasswordLengthException("The password should be of 8 or more characters");
        }
    }

    public static boolean validateUserPassword(String loginPassword, String dbStoredPassword) throws Exception {
        if(loginPassword.trim().equals(dbStoredPassword)) return true;

        throw new WrongPasswordException("Password is incorrect");
    }
}
