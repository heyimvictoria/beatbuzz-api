package org.launchcode.controllers;

import org.launchcode.controllers.Dto.FollowRequestDTO;
import org.launchcode.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {
    @PostMapping("/addPlaylist")
    public ResponseEntity<?> addPlaylist() {
        User playlist = userRepository.findByUsername.orElse(null);
        // make playlist add user id to it and whatever songs user inputs.

//        User followed = userRepository.findByUsername(?.getUsername()).orElse(null);
//        if (playlist == null || followed == null) {
//            return ResponseEntity.badRequest().build();
//        }
//        followService.addPlaylist(playlist, followed);
//        return ResponseEntity.ok().build();
//    }
}
