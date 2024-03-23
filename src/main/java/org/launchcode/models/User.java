package org.launchcode.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
public class User extends AbstractEntity implements Serializable {
    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    private String pwHash;


    public User(){}

    public User(String username, String pwHash) {
        this.username = username;
        this.pwHash = pwHash;
    }

    public String getUsername() {
        return username;
    }
}
