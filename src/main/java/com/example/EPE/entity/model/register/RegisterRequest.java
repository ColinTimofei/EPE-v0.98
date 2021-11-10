package com.example.EPE.entity.model.register;

import com.sun.istack.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter

public class RegisterRequest {
    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "First name shouldn't be empty")
    @Pattern(regexp = "^[A-Za-z]*$")
    private String firstName;

    @NotEmpty(message = "Last name shouldn't be empty")
    @Pattern(regexp = "^[A-Za-z]*$")
    private String lastName;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate birthDate;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate employmentDate;

    @NotEmpty(message = "Phone number shouldn't be empty")
    @Pattern.List({
            @Pattern(regexp = "\"^\\\\+(?:[0-9] ?){6,14}[0-9]$\""),
            @Pattern(regexp = "^[0-9]*$")
    })
    private String phoneNumber;

    @NotEmpty(message = "Job position shouldn't be empty")
    private String jobPosition;

    @NotEmpty(message = "Bio shouldn't be empty")
    private String Bio;

    @NotEmpty(message = "Photo shouldn't be empty")
    private String photo;

    @NotEmpty(message = "Password shouldn't be empty")
    private String password;

    @NotEmpty(message = "Confirmation of the password shouldn't be empty")
    private String confirmPassword;

    public RegisterRequest(String email, String firstName, String lastName,
                           LocalDate birthDate, LocalDate employmentDate,
                           String phoneNumber, String jobPosition, String bio,
                           String photo, String password, String confirmPassword) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.phoneNumber = phoneNumber;
        this.jobPosition = jobPosition;
        Bio = bio;
        this.photo = photo;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public RegisterRequest(){}
}
