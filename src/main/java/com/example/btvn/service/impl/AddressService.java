package com.example.btvn.service.impl;

import com.example.btvn.model.Address;
import com.example.btvn.repository.IAddressRepository;
import com.example.btvn.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AddressService implements IAddressService {
    @Autowired
    private IAddressRepository addressRepository;
    @Override
    public Iterable<Address> findAll() {

        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findOne(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void create(Address address) {
        addressRepository.save(address);

    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);

    }
}
