package com.example.springapp.controllers;

import com.example.springapp.classes.User;
import com.example.springapp.repositories.UserRepository;
import com.example.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;
    public UserController( UserService userService , UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<User> getUsers(){
        List<User> users =  userService.getAllUsers();
        return users;
    }

    @GetMapping("/{user_id}")
    public Optional<User> getUserById(@PathVariable Long user_id) throws Exception{
        return userService.getUserById(user_id);
    }

    @GetMapping("role/{role}")
    public Optional<List<User>> getUsersByRole(@PathVariable String role) throws Exception{
        return userService.getUsersByRole(role);
    }
    @PostMapping
    public User addUser(@RequestBody User user) throws Exception{
       return userService.addUser(user);
    }

    @DeleteMapping("/{user_id}")
    public Optional<User> deleteUser(@PathVariable Long user_id) throws Exception{
       return userService.deleteUser(user_id);
    }

    @PutMapping("/{user_id}")
    public User updateUser(@PathVariable Long user_id , @RequestBody User user) throws Exception{
        return userService.updateUser(user_id , user);
    }
}
