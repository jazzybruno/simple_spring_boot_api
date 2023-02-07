package com.example.springapp.classes;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Post {
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,
                    generator = "post_sequence")
private Long post_id;
private String description;
private String photos;
@ManyToOne
@JoinColumn(name = "user_id")
private User posterUser;

    public Post() {
    }

    public Post( String description, String photos, User poster_user) {
        this.description = description;
        this.photos = photos;
        this.posterUser = poster_user;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public User getPoster_user() {
        return posterUser;
    }

    public void setPoster_user(User poster_user) {
        this.posterUser = poster_user;
    }
}
