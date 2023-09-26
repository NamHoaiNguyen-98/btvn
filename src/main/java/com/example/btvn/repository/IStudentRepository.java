package com.example.btvn.repository;

import com.example.btvn.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {

//    @Query(value="select * from student where name like %?%", nativeQuery = true)
    List<Student> findAllByNameContaining(String name);

    List<Student> findAll();
    @Query(value="select * from student where name like %?%", nativeQuery = true)
    List<Student> searchByName(String name);

    @Query(value="select * from student  where idStatus=?", nativeQuery = true)
    List<Student> searchByStatus(Long id);
    @Query(value="select * from student where address_id=?", nativeQuery = true)
    List<Student> searchByAddress(Long id);
    @Query(value="select * from student join student_subject on student.idStudent=student_subject.student_id where subject_id=?", nativeQuery = true)
    List<Student> searchBySubject(Long id);
    @Query(value="select * from student where sex=?", nativeQuery = true)
    List<Student> searchBySex(String name);
    @Query(value = "select * from student join student_subject ss on student.idStudent = ss.student_id",nativeQuery = true)
    Iterable<Student> findAllSubject();
}
