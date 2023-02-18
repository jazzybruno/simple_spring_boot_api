package com.example.springapp.servicesImpl;
import com.example.springapp.classes.Post;
import com.example.springapp.classes.User;
import com.example.springapp.repositories.PostRepository;
import com.example.springapp.repositories.UserRepository;
import com.example.springapp.services.PostService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository,
                           UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getAllUsers() {
        return postRepository.findAll();
    }

    public Post postUser(Post post) throws Exception{
        try {
            Long user_id = post.getPoster_user().getUser_id();
            if (userRepository.existsById(user_id)){
                postRepository.save(post);
                return post;
            }else{
                throw new Exception("The saving user does not exist");
            }

        }catch (Exception e){
            throw new Exception("Failed to save the post");
        }
    }

    public Optional<Post> deletePost(Long postId) throws Exception {
        try {
            if(postRepository.existsById(postId)){
                Optional<Post> post = postRepository.findById(postId);
                postRepository.deleteById(postId);
                return post;
            }
        }catch (Exception e){
            throw new Exception("Failed to delete the user with id " + postId);
        }
        return null;
    }

    public void mapNewPost(Post post  , Post post1){
        post.setDescription(post1.getDescription());
        post.setPhotos(post1.getPhotos());
        post.setPoster_user(post1.getPoster_user());
    }
    @Transactional
    public Post updatePost(Long postId , Post post) throws Exception{
        try {
            Optional<Post> post1 = postRepository.findById(postId);
            Post post2 = post1.get();
            mapNewPost(post2 , post);
            return post2;
        }catch (Exception e){
            throw new Exception("Failed to update the post with id " + postId);
        }
    }

    public Optional<Post> getPostById(Long postId) throws Exception{
        if(postRepository.existsById(postId)){
            Optional<Post> post = postRepository.findById(postId);
            return post;
        }else{
            throw new Exception("The post with id: " + postId + " does not exist");
        }
    }

    public Optional<List<Post>> getPostByUser(Long userId) throws Exception {
        if(userRepository.existsById(userId)){
            Optional<User> user = userRepository.findById(userId);
            User user1 = user.get();
            Optional<List<Post>> posts = postRepository.findPostByPosterUser(user1);
            return posts;
        }else{
            throw new Exception("The user with the id: " + userId + " does not exist");
        }
    }
}
