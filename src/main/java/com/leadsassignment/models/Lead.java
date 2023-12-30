package com.leadsassignment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @NotNull(message = "leadId is mandatory")
    @Min(value = 1, message = "leadId should be greater than or equal to 1")
    @Column(unique = true)
    private Integer leadId;

    @NotBlank(message = "firstName is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "firstName should contain only alphabets")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]*$", message = "middleName should contain only alphabets")
    private String middleName;

    @NotBlank(message = "lastName is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "lastName should contain only alphabets")
    private String lastName;

    @NotNull(message = "mobileNumber is mandatory")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobileNumber")
    private String mobileNumber;

    @NotBlank(message = "Gender is mandatory")
    @Pattern(regexp = "^(Male|Female|Others)$", message = "Invalid Gender")
    private String gender;

    @NotNull(message = "DOB is mandatory")
    private String dateOfBirth;

    @Email(message = "Invalid email")
    private String email;


    public Lead() {
    }

    public Lead(Integer leadId, String firstName, String middleName, String lastName, String mobileNumber, String gender, String dateOfBirth, String email) {
        this.leadId = leadId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }
}
