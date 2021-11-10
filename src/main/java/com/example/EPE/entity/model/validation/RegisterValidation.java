package com.example.EPE.entity.model.validation;

import com.sun.istack.NotNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterValidation {

    public static boolean checkEmail(String emailToCheck) {
        Pattern emailPattern = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher emailMatcher = emailPattern.matcher(emailToCheck);
        return emailMatcher.matches();
    }

    public static boolean checkFirstName(String firstName) {
        return firstName.matches("^[A-Za-z]*$");
    }

    public static boolean checkLastName(String lastName) {
        return lastName.matches("^[A-Za-z]*$");
    }

    public static boolean checkBirthDate(LocalDate birthDate) {
        return birthDate.getYear() >= 1900;
    }

    public static boolean checkEmploymentDate(LocalDate employmentDate) {
        return LocalDate.now().compareTo(employmentDate) <= 0;
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        Pattern firstPattern = Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$");
        Pattern secondPattern = Pattern.compile("^[0-9]*$");
        Matcher firstMatcher = firstPattern.matcher(phoneNumber);
        Matcher secondMatcher = secondPattern.matcher(phoneNumber);
        return firstMatcher.matches() && phoneNumber.length() == 12 ||
                secondMatcher.matches() && phoneNumber.length() == 9;
    }

    public static boolean checkJobPosition(String jobPosition) {
         List<String> list = Arrays.asList("Developer", "Designer" , "Manager", "HR Recruiter", "Accountant");
         boolean flag = false;
         for (String value : list) {
             if (value.equals(jobPosition)) {
                 flag = true;
                 break;
             }
         }
         return flag;
    }

    public static boolean checkBio(String bio) {
        return bio != null && bio.length() != 0;
    }

    public static boolean verifyPassword(@NotNull String password, @NotNull String confirmationOfThePassword) {
        boolean firstFlag = password.length() == 0 ? false : true;
        boolean secondFlag = confirmationOfThePassword.length() == 0 ? false : true;
        if (firstFlag && secondFlag) {
            if (password.equals(confirmationOfThePassword)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
