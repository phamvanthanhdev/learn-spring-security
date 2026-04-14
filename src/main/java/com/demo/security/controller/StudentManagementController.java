package com.demo.security.controller;

import com.demo.security.entity.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/student")
public class StudentManagementController {
    private final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Alexander Isak"),
            new Student(2, "Novak Djokovic")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public String registerStudent(@RequestBody Student student) {
        System.out.println(student.toString());
        return "Register successful";
    }
}
