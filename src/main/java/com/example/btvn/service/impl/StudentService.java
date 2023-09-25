package com.example.btvn.service.impl;

import com.example.btvn.model.Student;

import com.example.btvn.service.IStudentService;


import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class StudentService implements IStudentService {


    @Override
    public Iterable<Student> findAll() {
        return null;
    }

    @Override
    public Optional<Student> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public void create(Student student) {

    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
