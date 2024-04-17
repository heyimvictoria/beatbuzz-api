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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository postRepository;

    @GetMapping("create")
    public String displayUserCreationForm(Model model) {
        model.addAttribute("title", "Create Name");
        model.addAttribute(new User());
        return "user/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid User newUser,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Name");
            return "user/create";
        }

        postRepository.save(newUser);
        return "redirect:/index";
    }
}
