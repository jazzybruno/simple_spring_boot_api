package com.example.springapp.services;

import com.example.springapp.classes.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<Post> getAllUsers();
    public Optional<Post> deletePost(Long postId) throws Exception;
    public void mapNewPost(Post post  , Post post1);
    public Post updatePost(Long postId , Post post) throws Exception;
    public Optional<Post> getPostById(Long postId) throws Exception;
    public Optional<List<Post>> getPostByUser(Long userId) throws Exception;
}
