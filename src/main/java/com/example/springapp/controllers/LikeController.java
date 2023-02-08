package com.example.springapp.controllers;

import com.example.springapp.classes.Like;
import com.example.springapp.repositories.LikeRepository;
import com.example.springapp.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/likes")
public class LikeController {
    private final LikeService likeService;
    private final LikeRepository likeRepository;
    public LikeController(LikeService likeService , LikeRepository likeRepository){
        this.likeService = likeService;
        this.likeRepository = likeRepository;
    }
    @GetMapping
    public List<Like> getAllLikes() throws Exception {
      return likeService.getAllLikes();
    }


    @GetMapping("like/{like_id}")
    public Optional<Like> getLikeById(@PathVariable Long like_id) throws Exception{
        return likeService.getLikeById(like_id);
    }
    @GetMapping("post/{post_id}")
    public Optional<List<Like>> getLikeByPost(@PathVariable Long post_id) throws Exception{
        return likeService.getLikeByPost(post_id);
    }
    @PostMapping
    public Like saveLike(@RequestBody Like like) throws Exception{
        return likeService.saveLike(like);
    }

    @DeleteMapping("/{like_id}")
    public Optional<Like> deleteLike(@PathVariable Long like_id) throws Exception{
        return likeService.deleteLike(like_id);
    }
}
