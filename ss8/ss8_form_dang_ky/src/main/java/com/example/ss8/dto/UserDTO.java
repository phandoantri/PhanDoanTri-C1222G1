package com.example.ss8.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class UserDTO implements Validator {
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;
    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;
    @Pattern(regexp = "^\\d{2}-0\\d{9}$")
    private String phoneNumber;

    private String age;
    //    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$")
    @Email
    private String email;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String  getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        LocalDate dayOfBirth=LocalDate.parse(userDTO.age);
        LocalDate now=LocalDate.now();
        int age=Period.between(now,dayOfBirth).getYears();
        if (age < 18) {
            errors.rejectValue("age", "age", "tuoi khong duoc nho hon 18");
        }
    }
}
