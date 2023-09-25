package com.example.btvn.service;
import com.example.btvn.model.Student;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;



public interface IStudentService extends IGenerateService<Student> {
    Page<Student> searchByName(String name, Pageable pageable);
    Page<Student> searchByStatus(Long id, Pageable pageable);
    Page<Student> searchBySubject(Long id, Pageable pageable);
    Page<Student> searchByAddress(String address, Pageable pageable);
}
