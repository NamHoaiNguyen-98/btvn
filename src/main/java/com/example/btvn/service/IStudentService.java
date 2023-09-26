package com.example.btvn.service;
import com.example.btvn.model.Filter;
import com.example.btvn.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService extends IGenerateService<Student> {

    List<Student> searchByName(String name);

    List<Student> searchByStatus(Long id);

    List<Student> searchByAddress(Long id);

    List<Student> searchBySubject(Long id);

    List<Student> searchBySex(String name);

    Iterable<Student> filter(Filter filter);

    Iterable<Student> findAllSubject();

    void addSubjectStudent(Long idStudent ,Long idSubject);

}

