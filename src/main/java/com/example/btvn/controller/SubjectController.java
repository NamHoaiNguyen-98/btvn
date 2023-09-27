package com.example.btvn.controller;

import com.example.btvn.model.Subject;
import com.example.btvn.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
    private ISubjectService subjectService;
    @GetMapping
    public ResponseEntity<Iterable<Subject>> showSubject(){
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveSubject(@RequestBody Subject subject) {
        subjectService.save(subject);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Subject> findById(@PathVariable Long id){
        Optional<Subject> subjectOptional = subjectService.findOne(id);
        if (!subjectOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subjectOptional.get(),HttpStatus.OK);
    }


}
