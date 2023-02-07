package com.example.springapp.config;

import com.example.springapp.classes.User;
import com.example.springapp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {


    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository userRepository){
     return args -> {
         User user = new User(
                 "jazzybruno",
                 "Dushimiyimana Jazzy Bruno",
                 "jazzybruno45@gmail.com",
                 "https://avatars.githubusercontent.com/u/95282931?v=4",
                 false,
                 LocalDate.of(2008 , 04 , 25),
                 "Teacher"
);
         User user1 = new User(
                 "bruno_jazzy",
                 "Dushimiyimana Joss Bruce",
                 "jossbruce45@gmail.com",
                 "https://avatars.githubusercontent.com/u/95282931?v=4",
                 false,
                 LocalDate.of(2011 , 04 , 25),
                 "Student"
         );
//         userRepository.saveAll(List.of(user1 , user));
     };
    }
}
