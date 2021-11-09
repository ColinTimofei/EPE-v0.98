package com.example.EPE.entity.model.register;

import lombok.Getter;

@Getter
public class RegisterResponse {
    private boolean accepted;

    public RegisterResponse(boolean accepted) {
        this.accepted = accepted;
    }

    public RegisterResponse(){}
}
