package com.example.springboot.controller;


import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Style;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student not found with this id" + id));
        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student studentDetails){
        Student updateStudent = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student not found with this id"+id));
//        updateStudent.setId(studentDetails.getId());
        updateStudent.setFirstName(studentDetails.getFirstName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setEmailId(studentDetails.getEmailId());
        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student not found with this id"+id));
        studentRepository.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



}
