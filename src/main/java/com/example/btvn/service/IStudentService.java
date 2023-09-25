package com.example.btvn.service;
import com.example.btvn.model.Filter;
import com.example.btvn.model.Student;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;



public interface IStudentService extends IGenerateService<Student> {
    Iterable<Student> filter(Filter filter);
}
