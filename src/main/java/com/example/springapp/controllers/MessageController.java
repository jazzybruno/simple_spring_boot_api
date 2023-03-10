package com.example.springapp.controllers;

import com.example.springapp.classes.Message;
import com.example.springapp.repositories.MessageRepository;
import com.example.springapp.servicesImpl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
private final MessageServiceImpl messageService;
private final MessageRepository  messageRepository;

@Autowired
public MessageController(MessageServiceImpl messageService , MessageRepository messageRepository){
    this.messageRepository = messageRepository;
    this.messageService = messageService;
}

//@GetMapping("/{sender}/{receiver}")
//public List<Message> getConversation(@PathVariable Long sender  , @PathVariable Long receiver) throws Exception{
////    return messageService.getConversation(sender , receiver);
//}

}
