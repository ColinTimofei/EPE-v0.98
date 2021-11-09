package com.example.EPE.entity.model.login;

import lombok.Getter;

@Getter
public class LoginResponse {
    private boolean accepted;

    public LoginResponse(){}

    public LoginResponse(boolean accepted) {
        this.accepted = accepted;
    }
}
