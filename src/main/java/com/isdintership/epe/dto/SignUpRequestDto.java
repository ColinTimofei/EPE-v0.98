package com.isdintership.epe.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SignUpRequestDto {

    @NotEmpty
    private String email;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    private String birthDate;
    private String employmentDate;
    private String phoneNumber;
    private String job;
    private String bio;
    @NotEmpty
    private String password;

}
