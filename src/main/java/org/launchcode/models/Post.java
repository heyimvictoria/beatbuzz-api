package org.launchcode.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class Post extends AbstractEntity {

    @NotBlank(message = "Review is required")
    @Column(length = 500)
    @Size(max=500, message = "Exceeds character limit")
    private String content;

    @NotBlank(message = "Rating is required")
    private int starRating;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "album_name")
    private String albumName;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public String getAlbumName() {
        return albumName;
    }
}

