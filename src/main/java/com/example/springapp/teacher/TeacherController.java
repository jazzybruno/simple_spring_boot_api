package com.example.springapp.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/teacher")
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }
    @GetMapping
    public List<Teacher> getTeacher(){
      return   teacherService.getTeachers();
    }
}
