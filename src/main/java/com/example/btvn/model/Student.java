package com.example.btvn.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idStudent;
    private String name;
    private String sex;
    @ManyToOne
    private Address address;
    private Integer subjects_count;
    @ManyToOne
    @JoinColumn(name = "idStatus")
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "student_subject", // Tên của bảng trung gian
            joinColumns = @JoinColumn(name = "student_id"), // Tên cột đại diện cho Student
            inverseJoinColumns = @JoinColumn(name = "subject_id") // Tên cột đại diện cho subject
    )
    Set<Subject> subjects;

    public Student() {
    }

    public Student(Long idStudent, String name, String sex, Address address, Integer subjects_count, Status status) {
        this.idStudent = idStudent;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.subjects_count = subjects_count;
        this.status = status;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getSubjects_count() {
        return subjects_count;
    }

    public void setSubjects_count(Integer subjects_count) {
        this.subjects_count = subjects_count;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
