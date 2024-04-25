package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.data.PostRepository;
import org.launchcode.data.UserRepository;
import org.launchcode.models.Post;
import org.launchcode.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //automatically serializes the return value of methods into JSON responses
@Controller //Handles web requests
//@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get request to retrieve users using method in UserRepository
    @GetMapping("/api/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

   //Get Request returns the name of the view template ("user/create") to be rendered.
    @GetMapping("/user/create")
    public String displayUserCreationForm(Model model) {
        model.addAttribute("title", "Create Name");
        model.addAttribute(new User());
        return "user/create";
    }

    //Post request receives JSON of new user and performs validation.
    @PostMapping("/api/user")
    User createUser(@RequestBody @Valid User newUser) {
        return userRepository.save(newUser);
    }

    //POST receives form data submitted by the user and validates
    @PostMapping("/user")
    public String processCreateEventForm(@ModelAttribute @Valid User newUser, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Name");
            return "user/create";
        }

        userRepository.save(newUser);
        return "redirect:/index";

    }
}
