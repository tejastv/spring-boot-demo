package com.tejastv.demo.rest;

import com.tejastv.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Aakash", "Shah"));
        theStudents.add(new Student("Ronak", "Waghela"));
        theStudents.add(new Student("Aman", "Valand"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // Check if the studentId is present or not
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
           throw new StudentNotFound("Student id is not fount " + studentId);
        }
        return theStudents.get(studentId);
    }

}





