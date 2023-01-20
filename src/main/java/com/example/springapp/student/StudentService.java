package com.example.springapp.student;

import java.time.LocalDate;
import java.util.List;

public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L ,
                        "Jazzy Bruno",
                        "jazzybruno45@gmail.com",
                        LocalDate.of(2006 , 04 , 25),
                        21
                ),
                new Student(
                        1L ,
                        "Jazzy Bruno",
                        "jazzybruno45@gmail.com",
                        LocalDate.of(2006 , 04 , 25),
                        21
                ),
                new Student(
                        1L ,
                        "Jazzy Bruno",
                        "jazzybruno45@gmail.com",
                        LocalDate.of(2006 , 04 , 25),
                        21
                ),
                new Student(
                        1L ,
                        "Jazzy Bruno",
                        "jazzybruno45@gmail.com",
                        LocalDate.of(2006 , 04 , 25),
                        21
                )
        );

    }
}
