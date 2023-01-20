package com.example.springapp.teacher;

import java.util.List;

public class StudentService {
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
