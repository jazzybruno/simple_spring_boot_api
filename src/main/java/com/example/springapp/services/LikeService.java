package com.example.springapp.services;

import com.example.springapp.classes.Like;
import com.example.springapp.classes.Post;
import com.example.springapp.repositories.LikeRepository;
import com.example.springapp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class LikeService {
    @Autowired
    private DataSource dataSource;
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    public LikeService(LikeRepository likeRepository,
                       PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
    }

    public List<Like> getAllLikes() throws Exception {
        try {
            return likeRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Failed to get all likes");
        }
    }
 public List<Map<String, Object>> getCustomizedLike(Long user_id , Long post_id ) throws Exception {
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
           return jdbcTemplate.queryForList("SELECT * FROM like_table WHERE post_id = '" + post_id + "' && user_id=' " + user_id + "'"  );
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Failed to fetch the like");
        }
 }
 public Like saveLike(Like like) throws Exception {
            List<Map<String  , Object>> likes = getCustomizedLike(like.getUser().getUser_id() , like.getPost().getPost_id());

            if(likes.size() != 0){
                throw new Exception("Already liked this post");
            };
            likeRepository.save(like);
            return like;
    }

    public Optional<Like> deleteLike(Long like_id) throws Exception {
        try {
            if(likeRepository.existsById(like_id)){
                Optional<Like> like = likeRepository.findById(like_id);
                likeRepository.deleteById(like_id);
                return like;
            }
            throw new Exception("The like does not exist");
        }catch (Exception e){
            throw new Exception("Failed to delete the like");
        }
    }

    public Optional<Like> getLikeById(Long likeId) throws Exception{
        if(likeRepository.existsById(likeId)){
            return likeRepository.findById(likeId);
        }
        throw new Exception("The like with id: " + likeId + " does not exist");
    }

    public Optional<List<Like>> getLikeByPost(Long postId) throws Exception{
       if(postRepository.existsById(postId)){
           Optional<Post> post = postRepository.findById(postId);
           Post post1 = post.get();
           return likeRepository.findByPost(post1);
       }
       throw new Exception("The post with id: " + postId + " does not exist");
    }
}
