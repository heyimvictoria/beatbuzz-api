package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.controllers.Dto.PostRequestDto;
import org.launchcode.data.PostRepository;
import org.launchcode.data.UserRepository;
import org.launchcode.models.Post;
import org.launchcode.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
//@RequestMapping("post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("api/posts/{postId}")
    public Optional<Post> getPostById(@PathVariable Integer postId) {
        return postRepository.findById(postId);
    }
   @GetMapping("/api/posts")
    List<Post> getAllPosts(){
       return postRepository.findAll();
   }
    @GetMapping("/post/create")
    public String displayPostReviewForm(Model model) {
        model.addAttribute("title", "Create Review");
        model.addAttribute("post", new Post());
        return "post/create";
    }

    @PostMapping("/api/posts")
    public ResponseEntity<String> createPost(@RequestBody @Valid PostRequestDto postDto) {
        // Extract information from the postDto and create a new Post object
        Post newPost = new Post();
        newPost.setContent(postDto.getContent());
        newPost.setStarRating(postDto.getStarRating());
        newPost.setAlbumName(postDto.getAlbumName());

        // Fetch the user from the database using the user ID provided in the postDto
        User user = userRepository.findById(postDto.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }

        // Set the user for the new post
        newPost.setUser(user);

        // Save the new post to the database
        postRepository.save(newPost);

        return ResponseEntity.status(HttpStatus.CREATED).body("Post created successfully");
    }
    @PostMapping("/post/create")
    public String processCreateEventForm(@ModelAttribute @Valid Post newPost,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Review");
            return "post/create";
        }

        postRepository.save(newPost);
        return "redirect:/index";
        }
    }
