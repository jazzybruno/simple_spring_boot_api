package com.example.springapp.teacher;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/teacher")
public class TeacherController {

    StudentService studentService = new StudentService();
    @GetMapping
    public List<Teacher> getTeacher(){
      return   studentService.getTeachers();
    }
}
