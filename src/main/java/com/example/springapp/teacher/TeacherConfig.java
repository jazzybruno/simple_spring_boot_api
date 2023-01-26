package com.example.springapp.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
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
                    true,
                    LocalDate.of(1990 , 05 , 25)
            );
            Teacher celestin =  new Teacher(
                    "Teacher 2",
                    "Subject 2",
                    "teacheremail@gmail.com",
                    true,
                    LocalDate.of(1970 , 05 , 25)
            );
            Teacher Tweep =  new Teacher(
                    "Teacher 2",
                    "Subject 2",
                    "teacheremail@gmail.com",
                    true,
                    LocalDate.of(1980 , 05 , 25)
            );
//            teacherRepository.saveAll(List.of(damscene , celestin));
        };
    }

}
