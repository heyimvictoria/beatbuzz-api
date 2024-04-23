package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.data.PostRepository;
import org.launchcode.data.UserRepository;
import org.launchcode.models.Post;
import org.launchcode.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository postRepository;
    @Autowired
    private UserRepository userRepository;
//    @GetMapping("create")
//    public String displayUserCreationForm(Model model) {
//        model.addAttribute("title", "Create Name");
//        model.addAttribute(new User());
//        return "user/create";
//    }

//    @RequestBody @Valid User newUser, Errors errors,) {
//        if(errors.hasErrors()) {
            @PostMapping("/create")
            public ResponseEntity<?> processCreateEventForm(@RequestBody @Valid User newUser) {
                User user = new User(newUser.getUsername(), newUser.getPwHash());
                try {
                    postRepository.save(user);
                    return ResponseEntity.ok("User registered!");
                }
                catch(Exception e) {
                    return ResponseEntity.badRequest().body("Registration failed!");
                }

            }
        }
