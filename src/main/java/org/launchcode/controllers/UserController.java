//package org.launchcode.controllers;
//
//import jakarta.validation.Valid;
//import org.launchcode.data.PostRepository;
//import org.launchcode.data.UserRepository;
//import org.launchcode.models.Post;
//import org.launchcode.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@Controller
////@RequestMapping("user")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/api/users")
//    List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
//    @GetMapping("/user/create")
//    public String displayUserCreationForm(Model model) {
//        model.addAttribute("title", "Create Name");
//        model.addAttribute(new User());
//        return "user/create";
//    }
//
//    @PostMapping("/api/user")
//    User createUser(@RequestBody @Valid User newUser) {
//        return userRepository.save(newUser);
//    }
//    @PostMapping("/user")
//    public String processCreateEventForm(@ModelAttribute @Valid User newUser, Errors errors, Model model) {
//        if(errors.hasErrors()) {
//            model.addAttribute("title", "Create Name");
//            return "user/create";
//        }
//
//        userRepository.save(newUser);
//        return "redirect:/index";
//
//    }
//}

package org.launchcode.controllers;

import org.launchcode.data.PostRepository;
import org.launchcode.data.UserRepository;
import org.launchcode.models.Post;
import org.launchcode.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}/posts")
    public List<Post> getUserPosts(@PathVariable Integer userId) {
        return postRepository.findByUser_Id(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @PostMapping("/user")
    public String processCreateEventForm(@ModelAttribute User newUser) {
        userRepository.save(newUser);
        return "redirect:/index";
    }
}

