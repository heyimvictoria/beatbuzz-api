package org.launchcode.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
public class Post extends AbstractEntity {

    @NotBlank(message = "Review is required")
    @Column(length = 500)
    @Size(max=500, message = "Exceeds character limit")
    private String content;

    @NotNull(message = "Rating is required")
    private Integer starRating;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "album_name")
    private String albumName;

    private int postId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }
}

