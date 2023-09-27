package com.example.btvn.service.impl;

import com.example.btvn.model.Subject;
import com.example.btvn.repository.ISubjectRepository;
import com.example.btvn.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private ISubjectRepository subjectRepository;
    @Override
    public Iterable<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findOne(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }



    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }


}
