package com.example.btvn.service.impl;

import com.example.btvn.model.Filter;
import com.example.btvn.model.Student;

import com.example.btvn.repository.IFilter;
import com.example.btvn.repository.IStudentRepository;
import com.example.btvn.service.IStudentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class StudentService implements IStudentService {
@Autowired
private IStudentRepository studentRepository;

@Autowired
private IFilter ifilter;

    @Override
    public Iterable<Student> findAll() {

        return studentRepository.findAll();
    }
    @Override
    public Iterable<Student> filter(Filter filter) {

        return ifilter.searchByFilter(filter.getSubject() ,filter.getSex() ,filter.getStatus());
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

        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }

}
