package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.data.PostRepository;
import org.launchcode.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

@RestController
@Controller
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("create")
    public String displayPostReviewForm(Model model) {
        model.addAttribute("title", "Create Review");
        model.addAttribute(new Post());
        return "posts/create";
    }

    @PostMapping("create")
    public String processPostReviewForm(@ModelAttribute @Valid Post newPost,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Review");
            return "posts/create";
        }

        postRepository.save(newPost);
        return "redirect:/index";
    }

    @GetMapping("delete")
    public String displayDeleteReviewForm(Model model) {
        model.addAttribute("title", "Delete Review");
        return "posts/delete";
    }

    @PostMapping("delete")
    public String processDeleteReviewForm(@RequestParam(required = false) Integer reviewid){

        if(reviewid != null) {
            postRepository.deleteById(reviewid);
        }
        return "redirect:/index";

    }

    @PutMapping("/{postId}")
    public void editPost(@PathVariable int postId, @RequestBody Post updatedPost) {
        Post existingPost = postRepository.findById(postId).orElse(null);
        if (existingPost == null) {
            throw new IllegalArgumentException("Post not found with ID: " + postId);
        }
        // Update the post content
        existingPost.setContent(updatedPost.getContent());
        postRepository.save(existingPost);
    }
}
