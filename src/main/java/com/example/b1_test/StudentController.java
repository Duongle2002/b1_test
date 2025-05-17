package com.example.b1_test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/students")
class StudentController {

    // In-memory list of students
    private List<Student> students = new ArrayList<>();

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", students);
        model.addAttribute("student", new Student()); // Add a new Student object for the form
        return "student-list";
    }

    @PostMapping
    public String addStudent(@ModelAttribute Student student) {
        student.setId(UUID.randomUUID().toString());
        students.add(student);
        return "redirect:/students";
    }
}
