package org.launchcode.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

@Entity
public class User extends AbstractEntity implements Serializable {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
public User(){}
    public User(String username, String pwHash) {
        this.username = username;
        this.pwHash = pwHash;
    }

    public String getUsername() {
        return username;
    }

    //added getters and setters
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }

    @Override
    public String toString() {
        return String.format("User [username=%s, pwHash=%s]", username, pwHash);

    }
}
