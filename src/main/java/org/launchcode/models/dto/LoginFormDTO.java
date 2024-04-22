package org.launchcode.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull
    @NotBlank
    @Size(min = 4, max = 20,  message = "Invalid Username. must be between 4 and 20 characters long.")
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 7, max = 30,  message = "Invalid password. must be between 7 and 30 characters long.")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
