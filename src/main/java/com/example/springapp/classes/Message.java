package com.example.springapp.classes;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long message_id;
    private LocalDate TimeSent;
    @ManyToOne
    @JoinColumn(name = "sender")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver")
    private User receiver;

    public Message(){

    }

    public Message(LocalDate timeSent, User sender, User receiver) {
        TimeSent = timeSent;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Long message_id) {
        this.message_id = message_id;
    }

    public LocalDate getTimeSent() {
        return TimeSent;
    }

    public void setTimeSent(LocalDate timeSent) {
        TimeSent = timeSent;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
