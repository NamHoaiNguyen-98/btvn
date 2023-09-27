package com.example.btvn.service.impl;

import com.example.btvn.model.*;

import com.example.btvn.repository.*;
import com.example.btvn.service.IStudentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ISubjectRepository subjectRepository;
    @Autowired
    private IStatusRepository statusRepository;
    @Autowired
    private IAddressRepository addressRepository;



    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Iterable<Student> filter(Filter filter) {
        List<Student> listAll = studentRepository.findAll();
        if (filter.getSubject().size() == 0){
            for (Subject subject:
                    subjectRepository.findAll()) {
                filter.getSubject().add(subject.getIdSubject());
            }
        }
        if (filter.getAddress().size() == 0){
            for (Address subject:
                    addressRepository.findAll()) {
                filter.getAddress().add(subject.getId());
            }
        }
        if (filter.getStatus().size() == 0){
            for (Status subject:
                    statusRepository.findAll()) {
                filter.getStatus().add(subject.getIdStatus());
            }
        }
        if (filter.getSex().size() == 0){
            filter.getSex().add("Nam");
            filter.getSex().add("Nữ");
        }

        List<Student> ft = listAll;

            for (int i = 0; i < listAll.size(); i++) {
                if (!(check(listAll.get(i).getAddress().getId(), filter.getAddress()))
                        || !(check(listAll.get(i).getStatus().getIdStatus(), filter.getStatus()))
                        || !(checkString(listAll.get(i).getSex(), filter.getSex()))
                        || !(checkSubject(listAll.get(i).getSubjects(), filter.getSubject()))
                ) {
                    if (ft.get(i) != null) {
                        ft.set(i, null);
                    }
                }
            }

        List<Student> listFt = new ArrayList<>();
        for (Student s :
                ft) {
            if (s != null) {
                listFt.add(s);
            }
        }
        Iterable<Student> students = listFt;
        return students;

    }

    public boolean checkSubject(Set<Subject> subjects, List<Long> longList) {
        for (int i = 0; i < longList.size(); i++) {
            for (Subject s :
                    subjects) {
                if (s.getIdSubject() == longList.get(i)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean check(Long aLong, List<Long> longList) {
        for (Long l :
                longList) {
            if (l == aLong) {
                return true;
            }
        }
        return false;
    }

    public boolean checkString(String s, List<String> stringList) {
        for (String l :
                stringList) {
            if (l.equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<Student> findAllSubject() {
        return null;
    }

    @Override
    public void addSubjectStudent(Long idStudent,Long idSubject) {
        studentRepository.addSubjectStudent(idStudent,idSubject);
    }


    @Override
    public Optional<Student> findOne(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);

    }


    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public List<Student> searchByName(String name) {
        return studentRepository.findAllByNameContaining(name);
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
