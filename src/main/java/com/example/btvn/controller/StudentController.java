package com.example.btvn.controller;

import com.example.btvn.model.Filter;
import com.example.btvn.model.Student;
import com.example.btvn.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> display() {
        Iterable<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        studentService.create(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{idStudent}")
    public ResponseEntity<Student> findOne(@PathVariable("idStudent") Long idStudent) {
        Optional<Student> student = studentService.findOne(idStudent);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{idStudent}")
    public ResponseEntity<Student> update(@PathVariable("idStudent") Long idStudent,
                                          @RequestBody Student student) {
        Optional<Student> studentOptional = studentService.findOne(idStudent);
        if (studentOptional.isPresent()) {
            student.setIdStudent(idStudent);
            return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{idStudent}")
    public ResponseEntity<Student> delete(@PathVariable("idStudent") Long idStudent) {
        Optional<Student> studentOptional = studentService.findOne(idStudent);
        if (studentOptional.isPresent()) {
            studentService.delete(idStudent);
            return new ResponseEntity<>(studentOptional.get(), HttpStatus.NO_CONTENT);
        }return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/filter")
    public ResponseEntity<Iterable<Student>> filter (@RequestBody Filter filter){
        Iterable<Student> students= studentService.filter(filter);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
