package com.example.springapp.teacher;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherService {
    public List<Teacher> getTeachers(){
        return List.of(
                new Teacher(
                        1 ,
                        "Teacher 2",
                        "Subject 2",
                        "teacheremail@gmail.com",
                        30,
                        true
                ),
                new Teacher(
                        1 ,
                        "Teacher 2",
                        "Subject 2",
                        "teacheremail@gmail.com",
                        30,
                        true
                ),
                new Teacher(
                        1 ,
                        "Teacher 2",
                        "Subject 2",
                        "teacheremail@gmail.com",
                        30,
                        true
                ),
                new Teacher(
                        1 ,
                        "Teacher 2",
                        "Subject 2",
                        "teacheremail@gmail.com",
                        30,
                        true
                ),
                new Teacher(
                        1 ,
                        "Teacher 2",
                        "Subject 2",
                        "teacheremail@gmail.com",
                        30,
                        true
                ),
                new Teacher(
                        1 ,
                        "Teacher 2",
                        "Subject 2",
                        "teacheremail@gmail.com",
                        30,
                        true
                )
        );
    }
}
