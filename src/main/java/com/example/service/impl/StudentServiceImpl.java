package com.example.service.impl;

import com.example.domain.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentById(Long id) {
        return null;
    }

    @Override
    public List<Student> getStudentsByBranch(String branchName) {
        return studentRepository.findByBranch(branchName);
    }

    @Override
    public Student showStudentsById(String branchName, Long studentId) {
        return studentRepository.showStudentsById(branchName, studentId);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentByIdAndBranch(Long studentId, String branchName) {
        return null;
    }
}
