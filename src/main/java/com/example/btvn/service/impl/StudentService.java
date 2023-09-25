package com.example.btvn.service.impl;

import com.example.btvn.model.Student;
import com.example.btvn.repository.IStudentRepository;
import com.example.btvn.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findOne(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);

    }

    @Override
    public Student update(Student student) {
        studentRepository.save(student);

        return student;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> searchByName(String name, Pageable pageable) {
        return studentRepository.searchByName(name, pageable);
    }

    @Override
    public Page<Student> searchByStatus(Long id, Pageable pageable) {
        return studentRepository.searchByStatus(id, pageable);
    }

    @Override
    public Page<Student> searchBySubject(Long id, Pageable pageable) {
        return studentRepository.searchBySubject(id, pageable);
    }

    @Override
    public Page<Student> searchByAddress(String address, Pageable pageable) {
        return studentRepository.searchByAddress(address, pageable);
    }


}
