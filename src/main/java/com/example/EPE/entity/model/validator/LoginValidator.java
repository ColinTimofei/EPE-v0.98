package com.example.EPE.entity.model.validator;

import com.example.EPE.entity.model.login.LoginRequest;
import com.example.EPE.entity.model.validation.LoginValidation;

public class LoginValidator {
    public static boolean checkAllLoginFields(LoginRequest loginRequest) {
        return LoginValidation.checkEmail(loginRequest.getEmail()) &&
                LoginValidation.checkPassword(loginRequest.getPassword());
    }
}
