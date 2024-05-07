package org.launchcode.services;

import org.launchcode.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {
    public ResponseEntity<?> saveUser(User user);
    Optional <User> findById(Long id);
}

