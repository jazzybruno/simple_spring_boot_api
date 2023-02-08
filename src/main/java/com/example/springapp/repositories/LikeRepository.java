package com.example.springapp.repositories;

import com.example.springapp.classes.Like;
import com.example.springapp.classes.Post;
import com.example.springapp.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like , Long> {
    Optional<List<Like>> findByPost(Post post);
}
