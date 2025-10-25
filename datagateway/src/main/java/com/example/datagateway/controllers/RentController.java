package com.example.datagateway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.createDTOs.CreateRentDTO;
import com.example.datagateway.services.interfaces.IRentService;

@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private IRentService rentService;

    @GetMapping("/")
    public ResponseEntity<List<RentDTO>> getAllRents() {
        List<RentDTO> rents = rentService.getAllRents();
        if(rents.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentDTO> getRentById(@PathVariable Long id) {
        RentDTO rent = rentService.getRentById(id);
        return ResponseEntity.ok(rent);
    }

    @PostMapping("/")
    public ResponseEntity<RentDTO> createRent(@RequestBody CreateRentDTO rent) {
        RentDTO createdRent = rentService.createRent(rent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentDTO> updateRent(@RequestBody CreateRentDTO rent, @PathVariable Long id) {
        RentDTO updatedRent = rentService.updateRent(rent, id);
        return ResponseEntity.ok(updatedRent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RentDTO> deleteRent(@PathVariable Long id) {
        RentDTO deletedRent = rentService.deleteRent(id);
        return ResponseEntity.ok(deletedRent);
    }
}
