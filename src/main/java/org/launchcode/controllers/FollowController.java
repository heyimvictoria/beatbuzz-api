package org.launchcode.controllers;

import org.launchcode.data.UserRepository;
import org.launchcode.models.User;
import org.launchcode.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/follow")
public class FollowController {
    @Autowired
    private FollowService followService;

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/follow")
    public ResponseEntity<?> followUser(@RequestParam Long followerId, @RequestParam Long followedId) {
        // Retrieve users by their IDs
        User follower = userRepository.findById(followerId).orElse(null);
        User followed = userRepository.findById(followedId).orElse(null);
        if (follower == null || followed == null) {
            return ResponseEntity.badRequest().build();
        }
        followService.followUser(follower, followed);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/unfollow")
    public ResponseEntity<?> unfollowUser(@RequestParam Long followerId, @RequestParam Long followedId) {
        // Retrieve users by their IDs
        User follower = userRepository.findById(followerId).orElse(null);
        User followed = userRepository.findById(followedId).orElse(null);
        if (follower == null || followed == null) {
            return ResponseEntity.badRequest().build();
        }
        followService.unfollowUser(follower, followed);
        return ResponseEntity.ok().build();
    }
    // Other endpoints as needed
}