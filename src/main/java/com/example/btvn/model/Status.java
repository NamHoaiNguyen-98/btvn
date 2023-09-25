package com.example.btvn.model;

import javax.persistence.*;

@Entity
@Table(name = "status")


public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatus;
    private String name;

    public Status() {
    }

    public Long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Long idStatus) {
        this.idStatus = idStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
