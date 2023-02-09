package com.example.springapp.controllers;

import com.example.springapp.classes.Post;
import com.example.springapp.repositories.PostRepository;
import com.example.springapp.servicesImpl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostServiceImpl postService;
    private final PostRepository postRepository;
    @Autowired
    public PostController(PostServiceImpl postService , PostRepository postRepository){
        this.postService = postService;
        this.postRepository = postRepository;
    }
    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllUsers();
    }

    @GetMapping("/{post_id}")
    public Optional<Post> getPostById(@PathVariable Long post_id) throws Exception{
        return postService.getPostById(post_id);
    }

    @GetMapping("/user/{user_id}")
    private Optional<List<Post>> getPostByUser(@PathVariable Long user_id) throws Exception{
        return postService.getPostByUser(user_id);
    }
    @PostMapping
    public Post savePost(@RequestBody Post post) throws Exception{
        return postService.postUser(post);
    }

    @DeleteMapping("/{post_id}")
    public Optional<Post> deletePost( @PathVariable Long post_id) throws Exception{
        return postService.deletePost(post_id);
    }

    @PutMapping("/{post_id}")
    public Post updatePost(@PathVariable Long post_id , @RequestBody Post post) throws Exception{
        return postService.updatePost(post_id , post);
    }
}
