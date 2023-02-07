package com.example.springapp.repositories;

import com.example.springapp.classes.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User , Long>{
    Optional<User> findByEmail(String email);
    @Query("SELECT * FROM user WHERE role = null" +
            " ")
    Optional<List<User>> findByRole(String role);

}
