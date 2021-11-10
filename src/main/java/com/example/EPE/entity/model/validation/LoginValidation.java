package com.example.EPE.entity.model.validation;

import com.sun.istack.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidation {

    public static boolean checkEmail(String emailToCheck) {
        Pattern emailPattern = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher emailMatcher = emailPattern.matcher(emailToCheck);
        return emailMatcher.matches();
    }

    public static boolean checkPassword(@NotNull String password) {
        return password.length() != 0;
    }
}
