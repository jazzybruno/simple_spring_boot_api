package com.example.springapp.classes;

import java.time.LocalDate;
import java.util.List;

public class Like {
    private Long like_id;
    private Post post;
    private User user;
    private LocalDate timeAdded;

    public Like(){

    }

    public Like(Post post, User user, LocalDate timeAdded) {
        this.post = post;
        this.user = user;
        this.timeAdded = timeAdded;
    }

    public Long getLike_id() {
        return like_id;
    }

    public void setLike_id(Long like_id) {
        this.like_id = like_id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalDate timeAdded) {
        this.timeAdded = timeAdded;
    }
}
