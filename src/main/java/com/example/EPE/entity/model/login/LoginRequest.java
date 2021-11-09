package com.example.EPE.entity.model.login;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest(){}

}
