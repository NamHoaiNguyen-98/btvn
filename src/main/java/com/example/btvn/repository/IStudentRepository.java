package com.example.btvn.repository;

import com.example.btvn.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IStudentRepository extends JpaRepository<Student,Long> {


}
