package com.example.springapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
            return studentService.getStudents();
           }
}
