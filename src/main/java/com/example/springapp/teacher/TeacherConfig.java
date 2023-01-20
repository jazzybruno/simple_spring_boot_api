package com.example.springapp.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeacherConfig {

    @Bean
    CommandLineRunner teachercommandLineRunner(TeacherRepository teacherRepository){
        return args -> {
            Teacher damscene =  new Teacher(
                    "Teacher 2",
                    "Subject 2",
                    "teacheremail@gmail.com",
                    30,
                    true
            );
            Teacher celestin =  new Teacher(
                    "Teacher 2",
                    "Subject 2",
                    "teacheremail@gmail.com",
                    30,
                    true
            );
            Teacher Tweep =  new Teacher(
                    "Teacher 2",
                    "Subject 2",
                    "teacheremail@gmail.com",
                    30,
                    true
            );
            teacherRepository.saveAll(List.of(damscene , Tweep , celestin));
        };
    }

}
