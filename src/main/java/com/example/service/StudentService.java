package com.example.service;

import com.example.domain.Student;

import java.util.List;

public interface StudentService {
    List<String> getAllBranchNames();
    Student getStudentById(Long id);
    List<Student> getStudentsByBranch(String branchName);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
}
