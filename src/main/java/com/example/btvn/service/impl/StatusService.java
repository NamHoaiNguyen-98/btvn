package com.example.btvn.service.impl;

import com.example.btvn.model.Status;
import com.example.btvn.repository.IStatusRepository;
import com.example.btvn.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class StatusService implements IStatusService {
    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public Iterable<Status> findAll() {
        return statusRepository.findAll();

    }

    @Override
    public Optional<Status> findOne(Long id) {
        return statusRepository.findById(id);
    }

    @Override
    public void create(Status status) {
        statusRepository.save(status);

    }

    @Override
    public Status update(Status status) {
        statusRepository.save(status);
        return status;
    }

    @Override
    public void delete(Long id) {
        statusRepository.deleteById(id);
    }


}
