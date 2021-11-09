package com.example.EPE.entity.model.register;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class RegisterRequest {
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate employmentDate;
    private String phoneNumber;
    private String jobPosition;
    private String Bio;
    private String photo;
    private String password;
    private String confirmPassword;

    public RegisterRequest(){}
}
