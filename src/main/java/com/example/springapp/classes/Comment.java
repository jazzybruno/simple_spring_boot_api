package com.example.springapp.classes;

import java.time.LocalDate;

public class Comment {
    private Long comment_id;
    private String content;
    private LocalDate added_time;
    private User user;
    private Post post;
    private Comment comment;

    public Comment(){

    }

    public Comment(String content, LocalDate added_time, User user, Post post) {
        this.content = content;
        this.added_time = added_time;
        this.user = user;
        this.post = post;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getAdded_time() {
        return added_time;
    }

    public void setAdded_time(LocalDate added_time) {
        this.added_time = added_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
