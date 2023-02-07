package com.example.springapp.classes;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Comment {
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,
                    generator = "comment_sequence"
     )
    private Long comment_id;
    private String content;
    private LocalDate addedTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @OneToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public Comment(){

    }

    public Comment(String content, LocalDate added_time, User user, Post post) {
        this.content = content;
        this.addedTime = added_time;
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
        return addedTime;
    }

    public void setAdded_time(LocalDate addedTime) {
        this.addedTime = addedTime;
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
