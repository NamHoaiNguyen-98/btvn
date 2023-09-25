package com.example.btvn.repository;

import com.example.btvn.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFilter extends JpaRepository<Student, Long> {
    @Query(value = "SELECT s.idStudent ,s.name ,s.sex ,s.subject FROM student as s JOIN student_subject ON student.idStudent = student_subject.student_id " +
            "WHERE idStudent IN :idStudent " +
            "AND sex IN :sex " +
            "AND idStatus IN :idStatus ",
            nativeQuery = true)
    List<Student> searchByFilter(@Param("idStudent") List<Long> idSubject, @Param("sex") List<Integer> sex, @Param("idStatus") List<Long> idStatus
    );
}
