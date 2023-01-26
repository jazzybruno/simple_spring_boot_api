package com.example.springapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService,
                             StudentRepository studentRepository){
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }
    @GetMapping
    public List<Student> getStudents(){
            return studentService.getStudents();
           };

    @PostMapping
    public void registerStudent(@RequestBody Student student) throws Exception {
         studentService.addNewStudent(student);
    }
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) throws Exception{
        studentService.removeStudent(id);
    }
    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) String name
                              ) throws Exception{
        studentService.changeStudent(id  , email , name);
    }
}
