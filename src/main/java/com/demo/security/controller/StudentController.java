package com.demo.security.controller;

import com.demo.security.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Alexander Isak"),
            new Student(2, "Novak Djokovic")
    );

    @GetMapping("{studentId}")
    private Student getStudentById(@PathVariable Integer studentId) {
        return STUDENTS.stream().filter(student -> student.getId() == studentId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }
}
