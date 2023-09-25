package com.example.btvn.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubject;
    private String name;
    private Integer capacity;
    @ManyToMany
    Set<Student> student;

    public Subject() {
    }

    public Subject(Long idSubject, String name, Integer capacity, Set<Student> student) {
        this.idSubject = idSubject;
        this.name = name;
        this.capacity = capacity;
        this.student = student;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    public Long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
