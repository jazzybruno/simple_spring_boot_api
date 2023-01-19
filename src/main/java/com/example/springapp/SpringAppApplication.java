package com.example.springapp;

import com.example.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}
     @GetMapping("/")
	 public static List<Student> hello(){
		return List.of(
				new Student(
						1L ,
						"Jazzy Bruno",
						"jazzybruno45@gmail.com",
						LocalDate.of(2006 , 04 , 25),
						21
				),
		 new Student(
				 1L ,
				 "Jazzy Bruno",
				 "jazzybruno45@gmail.com",
				 LocalDate.of(2006 , 04 , 25),
				 21
		 ),
		 new Student(
				 1L ,
				 "Jazzy Bruno",
				 "jazzybruno45@gmail.com",
				 LocalDate.of(2006 , 04 , 25),
				 21
		 ),
		 new Student(
				 1L ,
				 "Jazzy Bruno",
				 "jazzybruno45@gmail.com",
				 LocalDate.of(2006 , 04 , 25),
				 21
		 )
		);
	}
}
