package com.example.EPE.entity.model.validator;

import com.example.EPE.entity.model.register.RegisterRequest;
import com.example.EPE.entity.model.validation.RegisterValidation;

public class RegisterValidator {

    public static boolean checkAllRegisterFields(RegisterRequest registerRequest) {
        return RegisterValidation.checkEmail(registerRequest.getEmail()) &&
                RegisterValidation.checkFirstName(registerRequest.getFirstName()) &&
                RegisterValidation.checkLastName(registerRequest.getLastName()) &&
                RegisterValidation.checkBirthDate(registerRequest.getBirthDate()) &&
                RegisterValidation.checkEmploymentDate(registerRequest.getEmploymentDate()) &&
                RegisterValidation.checkPhoneNumber(registerRequest.getPhoneNumber()) &&
                RegisterValidation.checkJobPosition(registerRequest.getJobPosition()) &&
                RegisterValidation.checkBio(registerRequest.getBio()) &&
                RegisterValidation.verifyPassword(registerRequest.getPassword(), registerRequest.getConfirmPassword());
    }
}
