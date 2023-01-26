package com.example.springapp.teacher;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String name;
    private String subject;
    private String email;
    private LocalDate dob;
    private boolean isMarried;
    @Transient
    private Integer age;

    public Teacher(){

    }

    public Teacher(Long id, String name, String subject, String email, boolean isMarried , LocalDate dob) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.isMarried = isMarried;
        this.dob = dob;
    }

    public Teacher(String name, String subject, String email,  boolean isMarried , LocalDate dob) {
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.isMarried = isMarried;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return Period.between(this.dob , LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
