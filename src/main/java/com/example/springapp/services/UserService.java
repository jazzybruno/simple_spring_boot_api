package com.example.springapp.services;

import com.example.springapp.classes.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAllUsers();
    public User addUser(User user) throws Exception;
    public Optional<User> deleteUser(Long userId) throws Exception;
    public User updateUser(Long userId , User user) throws Exception;
    public Optional<User> getUserById(Long userId) throws Exception;
    public Optional<List<User>> getUsersByRole(String role) throws Exception;

}
