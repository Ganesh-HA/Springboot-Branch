package com.example.rest;

import com.example.domain.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String showBranches(Model model) {
        List<String> branchNames = studentService.getAllBranchNames();
        model.addAttribute("branchNames", branchNames);
        return "home"; // Make sure the view name matches your template name
    }
    @GetMapping("/branches/{branchName}")
    public List<Student> showStudentsByBranch(@PathVariable("branchName") String branchName) {
        List<Student> students = studentService.getStudentsByBranch(branchName);
        return students; // Change to your branch template name
    }

    @GetMapping("/student/{studentId}")
    public String viewStudent(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "student"; // Change to your student template name
    }

    @PostMapping("/student/{studentId}/edit")
    public String saveEditedStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/student/" + student.getId();
    }

    @GetMapping("/student/{studentId}/delete")
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/";
    }
}

