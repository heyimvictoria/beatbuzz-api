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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//Handles both RESTful and Web requests.
@RestController
@Controller
//@RequestMapping("post")
public class PostController {

    @Autowired
    //performs CRUD
    private PostRepository postRepository;

    @Autowired
    //Retrieves users
    private UserRepository userRepository;


    //Get request retrieves posts by their Id with the PostRepository method
    @GetMapping("/api/posts/{postId}")
    public Optional<Post> getPostById(@PathVariable Long postId) {
        return postRepository.findById(postId);
    }

    //Retrieves all posts
    @GetMapping("/api/posts")
    List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    //finds all posts made by same user
    @GetMapping("/api/posts/user/{userId}")
    public List<Post> getAllPostsByUser(@PathVariable Long userId) {
        return postRepository.findByUser_Id(userId);
    }


    @PostMapping("/api/posts")
    public ResponseEntity<String> createPost(@RequestBody @Valid PostRequestDto postDto) {
       System.out.println("Received post request: " + postDto);
        // Extract information from the postDto and create a new Post object
        Post newPost = new Post();
        newPost.setContent(postDto.getContent());
        newPost.setStarRating(postDto.getStarRating());
        newPost.setAlbumName(postDto.getAlbumName());
        newPost.setCreatedAt(LocalDateTime.now());


        // Fetch the user from the database using the user ID provided in the postDto
        User user = userRepository.findById(postDto.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }

        newPost.setUsername(user.getUsername());
        // Set the user for the new post
        newPost.setUser(user);
        //Set time of creation
        newPost.setCreatedAt(LocalDateTime.now());
        // Initialize likes to 0
        newPost.setLikes(0);
        // Save the new post to the database
        postRepository.save(newPost);

        return ResponseEntity.status(HttpStatus.CREATED).body("Post created successfully");
    }

//   Post request uses postId as path to identify post being liked.
    @PostMapping("/api/posts/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable Long postId) {
        try {
            Optional<Post> optionalPost = postRepository.findById(postId);
            if (optionalPost.isPresent()) {
                Post post = optionalPost.get();
                post.setLikes(post.getLikes() + 1);
                postRepository.save(post);
                return ResponseEntity.ok("Post liked successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error liking post");
        }
    }
    @GetMapping("/post/create")
    public String displayPostReviewForm(Model model) {
        model.addAttribute("title", "Create Review");
        model.addAttribute("post", new Post());
        return "post/create";
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




    @GetMapping("/post/edit/{postId}")
    public String displayEditForm(@PathVariable Long postId, Model model) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            model.addAttribute("title", "Edit Review");
            model.addAttribute("post", optionalPost.get());
            return "post/edit";
        } else {
            // Handle post not found scenario
            return "redirect:/error";
        }
    }

    @PutMapping("/api/posts/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Long postId, @RequestBody @Valid PostRequestDto postDto) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();
            // Update the existing post with the new data
            existingPost.setContent(postDto.getContent());
            existingPost.setStarRating(postDto.getStarRating());
            existingPost.setAlbumName(postDto.getAlbumName());

            // Save the updated post
            postRepository.save(existingPost);

            return ResponseEntity.status(HttpStatus.OK).body("Post updated successfully");
        } else {
            // If the post with the given ID does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
    }

    @DeleteMapping("/api/posts/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        try {
            postRepository.deleteById(postId);
            return ResponseEntity.ok().body("Post deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting post");
        }
    }

    @GetMapping("/api/posts/user/{postId}")
    public String getUserId(@PathVariable Long postId) {
         User user = userRepository.findById(postId).orElse(null);;
        return user.getUsername();
    }



}