package com.example.springapp.repositories;

import com.example.springapp.classes.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message , Long> {
}
