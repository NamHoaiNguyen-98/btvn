package com.example.btvn.repository;

import com.example.btvn.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository   extends JpaRepository<Address,Long> {
}
