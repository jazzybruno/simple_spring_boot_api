package com.example.springapp.teacher;

public class Teacher {
    private int id;
    private String name;
    private String subject;
    private String email;
    private Integer age;
    private boolean isMarried;

    public Teacher(int id, String name, String subject, String email, Integer age, boolean isMarried) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.age = age;
        this.isMarried = isMarried;
    }

    public Teacher(String name, String subject, String email, Integer age, boolean isMarried) {
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.age = age;
        this.isMarried = isMarried;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return age;
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
}
