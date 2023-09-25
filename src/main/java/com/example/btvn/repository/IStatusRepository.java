package com.example.btvn.repository;


import com.example.btvn.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status,Long> {
}
