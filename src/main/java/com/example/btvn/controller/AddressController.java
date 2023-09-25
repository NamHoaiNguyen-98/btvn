package com.example.btvn.controller;

import com.example.btvn.model.Address;
import com.example.btvn.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    private IAddressService addressService;
    @GetMapping
    public ResponseEntity<Iterable<Address>> display() {
        Iterable<Address> addresses = addressService.findAll();
        return new ResponseEntity<>(addresses,HttpStatus.OK);
    }



}
