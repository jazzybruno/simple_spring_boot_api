package com.example.springapp.services;

import com.example.springapp.classes.User;
import com.example.springapp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) throws Exception {
        try {
            Optional<User> userEmail = userRepository.findByEmail(user.getEmail());
            System.out.println(userEmail);
            if(userEmail.isPresent()){
                throw new Exception("The user with  the email already exists");
            }
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new Exception("Failed to save the user");
        }
    }

    public Optional<User> deleteUser(Long userId) throws Exception {
         try {
             Optional<User> user = userRepository.findById(userId);
             if(user.isPresent()){
                 userRepository.deleteById(userId);
                 return user;
             }
             throw new Exception("The user with id " + userId + " does not exist");

         }catch (Exception e){
             e.printStackTrace();
             throw new Exception("Failed to delete the user with id " + userId);
         }
    }

    @Transactional
    public User updateUser(Long userId , User user) throws Exception {
        if(!userRepository.existsById(userId)){
            throw new Exception("The user with id " + userId + " does not exist");
        }else {
            Optional<User> optional = userRepository.findByEmail(user.getEmail());
            if(optional.isPresent()){
              throw new Exception("The user with this email already exists");
            }else {
                Optional<User> user1 = userRepository.findById(userId);
                User user2 = user1.get();
                user2.setUsername(user.getUsername());
                user2.setFullNames(user.getFullNames());
                user2.setEmail(user.getEmail());
                user2.setMarried(user.isMarried());
                user2.setDob(user.getDob());
                user2.setProfilePic(user.getProfilePic());
                return user2;
            }
        }
    }

    public Optional<User> getUserById(Long userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()){
            throw new Exception("The user with the id " + userId + " does not exist");
        }
        return user;
    }

    public Optional<List<User>> getUsersByRole(String role) throws Exception{

      if(role == "Teacher" || role == "Student"){
          throw new Exception("Enter a valid role please");
      }else{
          Optional<List<User>> users = userRepository.findByRole(role);
          return users;
      }
    }
}
