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

@RestController
@Controller
//@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public String displayUserCreationForm(Model model) {
        model.addAttribute("title", "Create Name");
        model.addAttribute(new User());
        return "user/create";
    }

    @PostMapping("/user")
//    public String processCreateEventForm(@RequestBody @Valid User newUser, Errors errors, Model model) {
//        if(errors.hasErrors()) {
//            model.addAttribute("title", "Create Name");
//            return "user/create";
//        }
//
//        userRepository.save(newUser);
//        return "redirect:/index";



User newUser(@RequestBody User newUser){
    return userRepository.save(newUser);


    }
}
