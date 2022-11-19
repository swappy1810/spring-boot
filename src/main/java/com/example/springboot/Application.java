package com.example.springboot;

import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student();
		student.setId(1L);
		student.setFirstName("swapnali");
		student.setLastName("kantekure");
		student.setEmailId("swapnali_kantekure@gmail.com");
		studentRepository.save(student);

		Student student1 = new Student();
		student1.setId(2L);
		student1.setFirstName("Ananya");
		student1.setLastName("pandey");
		student1.setEmailId("ananya_pandey@gmail.com");
		studentRepository.save(student1);
	}
}
