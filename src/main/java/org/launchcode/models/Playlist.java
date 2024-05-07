package org.launchcode.models;

import jakarta.persistence.*;

@Entity
public class Playlist {

    @ManyToOne
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Playlist() {
    }

    public Playlist(User user, Long id) {
        this.user = user;
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //    @ManyToOne
//    private Playlist playlist;
}
