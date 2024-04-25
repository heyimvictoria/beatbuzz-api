package org.launchcode.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Post extends AbstractEntity {

@Id
@GeneratedValue
private Integer id;


    @NotBlank(message = "Review is required")
    @Column(length = 500)
    @Size(max = 500, message = "Exceeds character limit")
    private String content;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private int starRating;

    private String albumName;
    //Many posts can belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore // prevents serialization of the User when converting to JSON
    private User user;
    private LocalDateTime createdAt;
    private Integer likes;

    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
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

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public String getAlbumName() {
        return albumName;
    }

    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    //If user not null post has an associated user, otherwise return null.
    public Integer getUserId() { return user != null ? user.getId() : null;}
    //Returns a string representation
    @Override
    public String toString() {
        return String.format("Post [id=%s, content=%s, starRating=%d, albumName=%s, createdAt=%s, likes=%d]", id, content, starRating, albumName, createdAt, likes);
    }
}

