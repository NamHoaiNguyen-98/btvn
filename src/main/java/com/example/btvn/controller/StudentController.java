package com.example.btvn.controller;

import com.example.btvn.model.Student;
import com.example.btvn.service.IStudentService;
import com.example.btvn.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/searchByName/{name}")
    public ResponseEntity<Iterable<Student>> searchByName(@PathVariable String name) {
            return new ResponseEntity<>(studentService.searchByName(name), HttpStatus.OK);
    }
//    @GetMapping("/searchByStatus/{id}")
}
