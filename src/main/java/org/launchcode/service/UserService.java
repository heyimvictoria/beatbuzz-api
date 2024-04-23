package org.launchcode.service;

import org.launchcode.models.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity <?> saveUser(User user);
}
