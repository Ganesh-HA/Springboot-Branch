package com.example.service;

import com.example.domain.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService {
//    List<String> getAllBranchNames();
//
    Student getStudentById(Long id);

    List<Student> getStudentsByBranch(String branchName);

    Student showStudentsById(String branchName, Long studentId);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long id);
    void addStudent(Student student);

    Student getStudentByIdAndBranch(Long studentId, String branchName);
}