package com.example.EPE.entity.model.login;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
@AllArgsConstructor
public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest(){}

}
