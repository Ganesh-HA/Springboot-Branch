package com.example.service.impl;

import com.example.domain.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<String> getAllBranchNames() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(Student::getBranch)
                .distinct()
                .collect(Collectors.toList());
    }
  @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getStudentsByBranch(String branchName) {
        return studentRepository.findByBranch(branchName);
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
}

