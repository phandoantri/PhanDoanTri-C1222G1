package com.example.ss8.modelDTO;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

public class UserDTO {
    @NotEmpty
    @Size(min = 5,max = 45)
    private String firstName;
    @NotEmpty
    @Size(min = 5,max = 45)
    private String lastName;
    @Pattern(regexp = "^\\d{2}-0\\d{9}$")
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date age;
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$")
    private String email;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, Date age, String email) {
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

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
