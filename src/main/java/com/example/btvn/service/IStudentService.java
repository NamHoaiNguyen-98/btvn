package com.example.btvn.service;
import com.example.btvn.model.Student;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;


public interface IStudentService extends IGenerateService<Student> {
    List<Student> searchByName(String name);
    List<Student> searchByStatus(Long id);
    List<Student> searchBySubject(Long id);
    Page<Student> searchByAddress(String address);
}
