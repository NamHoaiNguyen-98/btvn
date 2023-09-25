package com.example.btvn.service.impl;

import com.example.btvn.model.Student;

import com.example.btvn.repository.IStudentRepository;
import com.example.btvn.service.IStudentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;




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

    @Override
    public List<Student> searchByName(String name) {
        return studentRepository.searchByName(name);
    }

    @Override
    public List<Student> searchByStatus(Long id) {
        return studentRepository.searchByStatus(id);
    }

    @Override
    public List<Student> searchByAddress(Long id) {
        return studentRepository.searchByAddress(id);
    }

    @Override
    public List<Student> searchBySubject(Long id) {
        return studentRepository.searchBySubject(id);
    }

    @Override
    public List<Student> searchBySex(String name) {
        return studentRepository.searchBySex(name);
    }
}
