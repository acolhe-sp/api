package com.sptech.apikraken.dto.request;

public class LogonDTO {
    private String email;
    private String password;

    public LogonDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LogonDTO() {}

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
}
