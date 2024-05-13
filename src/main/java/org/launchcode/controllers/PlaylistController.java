package org.launchcode.controllers;

//import org.launchcode.data.PlaylistRepository;
//import org.launchcode.data.SongRepository;
import org.launchcode.data.UserRepository;
import org.launchcode.models.Playlist;
import org.launchcode.models.Song;
import org.launchcode.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
//@RestController
//@RequestMapping("/api/playlist")
//public class PlaylistController {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PlaylistRepository playlistRepository;
//
//    @Autowired
//    private SongRepository songRepository;
//
//
//    @PostMapping("/create")
//    public ResponseEntity<String> createPlaylist(@RequestParam String username,
//                                                 @RequestParam String playlistName,
//                                                 @RequestBody List<Song> songs) {
//
//        User user = userRepository.findByUsername(username).get();
//
//                Playlist playlist = new Playlist();
//        playlist.setUser(user);
//        playlist.setPlaylistName(playlistName);
//
//        playlistRepository.save(playlist);
//
//        for (Song song : songs) {
//            song.setPlaylist(playlist);
//            songRepository.save(song);
//        }
//
//        return ResponseEntity.status(HttpStatus.CREATED).body("Playlist created successfully");
//    }
//}


// make playlist add user id to it and whatever songs user inputs.

