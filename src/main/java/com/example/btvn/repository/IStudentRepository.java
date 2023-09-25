package com.example.btvn.repository;

import com.example.btvn.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {


}
