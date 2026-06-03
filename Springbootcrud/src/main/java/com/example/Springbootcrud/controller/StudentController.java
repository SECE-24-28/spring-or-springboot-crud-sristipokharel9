package com.example.Springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.Springbootcrud.model.Student;
import com.example.Springbootcrud.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    StudentService s;

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return s.getAllStudent();
    }

    @GetMapping("/students/{rno}")
    public Student getStudentByRollNo(@PathVariable("rno") int roll) {
        return s.getStudentByRollNo(roll);
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Student std) {
        s.addStudent(std);
        return "Student added successfully";
    }

    @PutMapping("/students/{rno}")
    public String updateStudent(@PathVariable("rno") int rno,
                                @RequestBody Student std) {
        std.setRno(rno);
        return s.updateStudent(std);
    }

    @DeleteMapping("/students/{rno}")
    public String deleteStudent(@PathVariable("rno") int rno) {
        return s.deleteStudent(rno);
    }
}