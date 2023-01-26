package com.example.springapp.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StudentService {
   private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void addNewStudent(Student student) throws Exception {
        Optional <Student> studentEmail =  studentRepository.getStudentByEmail(student.getEmail());
        if(studentEmail.isPresent()){
          throw new Exception("The Email already exists");
        }
        studentRepository.save(student);
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();

    }

    public void removeStudent(Long id) throws Exception {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new Exception("The item with id: " + id + " does not exist");
        }
        studentRepository.deleteById(id);

    }

    @Transactional
    public void changeStudent(Long id, String email , String name) throws Exception{
        if(!studentRepository.existsById(id)){
            throw new Exception("The user with id" + id + " does not exists");
        }

        Optional<Student> student = studentRepository.findById(id);
        Student student1 = student.get();
        if(name != null && email.length() > 0 && !Objects.equals(student1.getName() , name)){
            student1.setName(name);
        }

       if(email != null){
           if(email != null && email.length() > 0 && !Objects.equals(student1.getEmail() , email) ){
               Optional optional = studentRepository.getStudentByEmail(email);
               if(optional.isPresent()){
                   throw new Exception("The email is already taken!");
               }
               student1.setEmail(email);
           }
       }

    }
}
