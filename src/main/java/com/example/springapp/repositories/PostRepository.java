package com.example.springapp.repositories;

import com.example.springapp.classes.Post;
import com.example.springapp.classes.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post , Long> {

    Optional<List<Post>> findPostByPosterUser(User user);
}
