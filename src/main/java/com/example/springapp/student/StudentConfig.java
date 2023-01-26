package com.example.springapp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository studentRepository){
        return args -> {
           Student jazzy =  new Student(
                    "Jazzy",
                    "jazzy45@gmail.com",
                    LocalDate.of(2006 , 04 , 25)

            );
           Student bruno =  new Student(
                    "Bruno",
                    "bruno45@gmail.com",
                    LocalDate.of(2008 , 04 , 25)

            );
           studentRepository.saveAll(List.of(
                   jazzy , bruno
           ));
        };

    }
}
