package org.launchcode.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

//@Entity
////objects in class can be serialized for data persistence
//public class User extends AbstractEntity implements Serializable {
//
//    @NotNull
//    private String username;
//
//    @NotNull
//    private String pwHash;
//    @OneToMany(mappedBy = "user")
//    private List<Post> posts;
//public User(){}
//    public User(String username, String pwHash) {
//        this.username = username;
//        this.pwHash = pwHash;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    //added getters and setters
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPwHash() {
//        return pwHash;
//    }
//
//    public void setPwHash(String pwHash) {
//        this.pwHash = pwHash;
//    }
//
//    //Returns a string representation
//    @Override
//    public String toString() {
//        return String.format("User [username=%s, pwHash=%s]", username, pwHash);
//
//    }
//}


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}