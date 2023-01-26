package com.example.springapp.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher) throws IllegalAccessException {
        teacherService.insertTeacher(teacher);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long id) throws IllegalAccessException {
        teacherService.removeTeacher(id);
    }
}
