package com.example.springapp.teacher;

import com.example.springapp.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher , Long> {

    Optional <Student>getTeachersByEmail(String Email);
}
