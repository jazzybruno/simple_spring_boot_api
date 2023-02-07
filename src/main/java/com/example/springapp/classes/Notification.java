package com.example.springapp.classes;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long not_id;
    private String content;
    private boolean isRead;
    private LocalDate addedTime;

    public Notification(){

    }

    public Notification(String content, boolean isRead, LocalDate addedTime) {
        this.content = content;
        this.isRead = isRead;
        this.addedTime = addedTime;
    }

    public Long getNot_id() {
        return not_id;
    }

    public void setNot_id(Long not_id) {
        this.not_id = not_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDate getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDate addedTime) {
        this.addedTime = addedTime;
    }
}
