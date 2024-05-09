package org.launchcode.controllers.Dto;

public class FollowRequestDTO {

    private String username;
    private  String postUser;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostUser() {
        return postUser;
    }

    public void setPostUser(String postUser) {
        this.postUser = postUser;
    }
}
