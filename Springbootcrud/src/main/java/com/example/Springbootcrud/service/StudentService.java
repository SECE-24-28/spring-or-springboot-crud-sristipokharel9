package com.example.Springbootcrud.service;

import com.example.Springbootcrud.model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "John", "sb"),
            new Student(2, "Priya", "react")
    ));

    public List<Student> getAllStudent() {
        return students;
    }

    public Student getStudentByRollNo(int roll) {

        int index = 0;
        boolean flag = true;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRno() == roll) {
                index = i;
                flag = false;
                break;
            }
        }

        if (flag) {
            return new Student();
        } else {
            return students.get(index);
        }
    }

    public void addStudent(Student std) {
        students.add(std);
    }

    public String updateStudent(Student std) {

        int index = 0;
        boolean flag = true;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRno() == std.getRno()) {
                index = i;
                flag = false;
                break;
            }
        }

        if (flag) {
            return "No Such Data";
        } else {
            students.set(index, std);
            return "Student updated successfully";
        }
    }

    public String deleteStudent(int rno) {

        int index = 0;
        boolean flag = true;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRno() == rno) {
                index = i;
                flag = false;
                break;
            }
        }

        if (flag) {
            return "No Such Data";
        } else {
            students.remove(index);
            return "Student deleted successfully";
        }
    }
}