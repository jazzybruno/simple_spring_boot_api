package com.example.springapp.repositories;

import com.example.springapp.classes.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like , Long> {
}
