package org.launchcode.models;

import jakarta.persistence.*;
//
//@Entity
//public class Song {
//
//    @ManyToOne
//    private Playlist playlist;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String songTitle;
//
//    private String artist;
//
//    public Song() {
//    }
//
//    public Song(Playlist playlist, Long id, String songTitle, String artist) {
//        this.playlist = playlist;
//        this.id = id;
//        this.songTitle = songTitle;
//        this.artist = artist;
//    }
//
//    public Playlist getPlaylist() {
//        return playlist;
//    }
//
//    public void setPlaylist(Playlist playlist) {
//        this.playlist = playlist;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSongTitle() {
//        return songTitle;
//    }
//
//    public void setSongTitle(String songTitle) {
//        this.songTitle = songTitle;
//    }
//
//    public String getArtist() {
//        return artist;
//    }
//
//    public void setArtist(String artist) {
//        this.artist = artist;
//    }
//}
