package com.example.springapp.teacher;

import com.example.springapp.student.Student;
import com.example.springapp.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeacherService {
    TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository,
                          StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void insertTeacher(Teacher teacher) throws IllegalAccessException {
        if(studentRepository.getStudentByEmail(teacher.getEmail()).isPresent()){
            throw new IllegalAccessException("Email Already Taken...");
        }
        teacherRepository.save(teacher);
    }

    public void removeTeacher(Long id) throws IllegalAccessException {
        if(!studentRepository.existsById(id)){
            throw new IllegalAccessException("The user with id: " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }
}

