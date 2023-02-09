package com.example.springapp.services;

import com.example.springapp.classes.Like;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface LikeService {
    public List<Like> getAllLikes() throws Exception;
    List<Map<String, Object>> getCustomizedLike(Long user_id , Long post_id ) throws Exception;
    public Like saveLike(Like like) throws Exception;
    public Optional<Like> deleteLike(Long like_id) throws Exception;
    public Optional<Like> getLikeById(Long likeId) throws Exception;
    public Optional<List<Like>> getLikeByPost(Long postId) throws Exception;

}
