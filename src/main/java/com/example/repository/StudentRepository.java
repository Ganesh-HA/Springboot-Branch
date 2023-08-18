package com.example.repository;

import com.example.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByBranch(String branchName);
    @Query("SELECT s from Student s where s.branch=:branchName and s.id=:studentId")
    Student showStudentsById(String branchName,Long studentId);

}

