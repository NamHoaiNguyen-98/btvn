package com.example.btvn.controller;

import com.example.btvn.model.Filter;
import com.example.btvn.model.Student;
import com.example.btvn.model.Subject;
import com.example.btvn.service.IStudentService;
import com.example.btvn.service.ISubjectService;
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
    @Autowired
    private ISubjectService subjectService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> display() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/subjects")
    public ResponseEntity<Iterable<Subject>>showSubject(){
        return new ResponseEntity<>(subjectService.findAll(),HttpStatus.OK);
    }

    @PostMapping ("/{idStudent}/{idSubject}")
    public ResponseEntity<Void> sub(@PathVariable Long idStudent,@PathVariable Long idSubject){
        studentService.addSubjectStudent(idStudent,idSubject);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
    @GetMapping("/searchByName/{name}")
    public ResponseEntity<Iterable<Student>> searchByName(@PathVariable String name) {
        return new ResponseEntity<>(studentService.searchByName(name), HttpStatus.OK);
    }
    @GetMapping("/searchByStatus/{id}")
    public ResponseEntity<Iterable<Student>> searchByStatus(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.searchByStatus(id), HttpStatus.OK);
    }
    @GetMapping("/searchBySubject/{id}")
    public ResponseEntity<Iterable<Student>> searchBySubject(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.searchBySubject(id), HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<Iterable<Student>> filter (@RequestBody Filter filter){
        Iterable<Student> students= studentService.filter(filter);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
