package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.data.PostRepository;
import org.launchcode.models.Post;
import org.launchcode.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

@RestController
@Controller
//@RequestMapping("post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("create")
    public String displayPostReviewForm(Model model) {
        model.addAttribute("title", "Create Review");
        model.addAttribute(new Post());
        return "post/create";
    }

    @PostMapping("/post")
    public String processCreateEventForm(@RequestBody @Valid Post newPost,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Review");
            return "post/create";
        }

        postRepository.save(newPost);
        return "redirect:/index";

//    Post newPost(@RequestBody Post newPost){
//        return postRepository.save(newPost);

    }

    }
