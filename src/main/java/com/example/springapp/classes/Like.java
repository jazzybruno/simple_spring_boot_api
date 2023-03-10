package com.example.springapp.classes;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "likeTable")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO
    )
    private Long like_id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
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
