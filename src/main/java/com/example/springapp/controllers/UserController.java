package com.example.springapp.controllers;

import com.example.springapp.classes.User;
import com.example.springapp.repositories.UserRepository;
import com.example.springapp.servicesImpl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;
    public UserController(UserServiceImpl userService , UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping
    @ApiOperation(value = "Get users data", response = User.class)
    public List<User> getUsers(){
        List<User> users =  userService.getAllUsers();
        return users;
    }

    @GetMapping("/{user_id}")
    @ApiOperation(value = "Get users data", response = User.class)
    public Optional<User> getUserById(@PathVariable Long user_id) throws Exception{
        return userService.getUserById(user_id);
    }

    @GetMapping("role/{role}")
    @ApiOperation(value = "Get users data", response = User.class)
    public Optional<List<User>> getUsersByRole(@PathVariable String role) throws Exception{
        return userService.getUsersByRole(role);
    }
    @PostMapping
    @ApiOperation(value = "Get users data", response = User.class)
    public User addUser(@RequestBody User user) throws Exception{
       return userService.addUser(user);
    }

    @DeleteMapping("/{user_id}")
    @ApiOperation(value = "Get users data", response = User.class)
    public Optional<User> deleteUser(@PathVariable Long user_id) throws Exception{
       return userService.deleteUser(user_id);
    }

    @PutMapping("/{user_id}")
    @ApiOperation(value = "Get users data", response = User.class)
    public User updateUser(@PathVariable Long user_id , @RequestBody User user) throws Exception{
        return userService.updateUser(user_id , user);
    }
}
