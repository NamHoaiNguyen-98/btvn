package com.example.btvn.controller;

import com.example.btvn.model.Status;
import com.example.btvn.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    private IStatusService statusService;

    @GetMapping
    public ResponseEntity<Iterable<Status>> display() {
        Iterable<Status> status = statusService.findAll();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Status status){
        statusService.save(status);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{idStatus}")
    public ResponseEntity<Optional<Status>> findOne(@PathVariable("idStatus") Long idStatus) {
        Optional<Status> status = statusService.findOne(idStatus);
        if(status.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
