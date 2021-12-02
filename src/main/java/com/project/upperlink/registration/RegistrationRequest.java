package com.project.upperlink.registration;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String resume_name;
    private long resume_size;
    private Date resume_uploadTime;
    private byte[] resume_content;
    private String passport_name;
    private long passport_size;
    private Date passport_uploadTime;
    private byte[] passport_content;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResume_name() {
        return resume_name;
    }

    public void setResume_name(String resume_name) {
        this.resume_name = resume_name;
    }

    public long getResume_size() {
        return resume_size;
    }

    public void setResume_size(long resume_size) {
        this.resume_size = resume_size;
    }

    public Date getResume_uploadTime() {
        return resume_uploadTime;
    }

    public void setResume_uploadTime(Date resume_uploadTime) {
        this.resume_uploadTime = resume_uploadTime;
    }

    public byte[] getResume_content() {
        return resume_content;
    }

    public void setResume_content(byte[] resume_content) {
        this.resume_content = resume_content;
    }

    public String getPassport_name() {
        return passport_name;
    }

    public void setPassport_name(String passport_name) {
        this.passport_name = passport_name;
    }

    public long getPassport_size() {
        return passport_size;
    }

    public void setPassport_size(long passport_size) {
        this.passport_size = passport_size;
    }

    public Date getPassport_uploadTime() {
        return passport_uploadTime;
    }

    public void setPassport_uploadTime(Date passport_uploadTime) {
        this.passport_uploadTime = passport_uploadTime;
    }

    public byte[] getPassport_content() {
        return passport_content;
    }

    public void setPassport_content(byte[] passport_content) {
        this.passport_content = passport_content;
    }
}
