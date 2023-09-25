package com.example.btvn.service;
import com.example.btvn.model.Filter;
import com.example.btvn.model.Student;

import java.util.List;

public interface IStudentService extends IGenerateService<Student> {
<<<<<<< HEAD
    List<Student> searchByName(String name);
    List<Student> searchByStatus(Long id);
    List<Student> searchByAddress(Long id);
    List<Student> searchBySubject(Long id);
    List<Student> searchBySex(String name);
=======
    Iterable<Student> filter(Filter filter);
>>>>>>> ft
}
