package com.example.rest;

import com.example.domain.Student;
import com.example.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/branches/{branchName}")
    public List<Student> showStudentsByBranch(@PathVariable("branchName") String branchName) {
        List<Student> students = studentService.getStudentsByBranch(branchName);
        return students;
    }

    @GetMapping("/branches/{branchName}/student/{studentId}")
    public Student showStudentById(@PathVariable("branchName") String branchName, @PathVariable Long studentId) {
        Student student = studentService.showStudentsById(branchName,studentId);
        return student;
    }

    @PostMapping("/students/add")
    public List<Student> addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return studentService.getStudentsByBranch(student.getBranch());
    }

    @PutMapping("/students/{studentId}/edit")
    public List<Student> editStudent(@PathVariable Long studentId, @RequestBody Student updatedStudent) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            updatedStudent.setId(studentId);
            studentService.updateStudent(updatedStudent);
        }
        return studentService.getStudentsByBranch(updatedStudent.getBranch());
    }

    @DeleteMapping("/students/{studentId}/delete")
    public List<Student> deleteStudent(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            studentService.deleteStudent(studentId);
        }
        return studentService.getStudentsByBranch(student.getBranch());
    }
}










