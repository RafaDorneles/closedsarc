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

import com.example.common.dtos.EquipementDTO;
import com.example.common.dtos.createDTOs.CreateEquipementDTO;
import com.example.datagateway.services.interfaces.IEquipementService;

@RestController
@RequestMapping("/equipements")
public class EquipementController {
    
    @Autowired
    private IEquipementService equipementService;

    @GetMapping("/")
    public ResponseEntity<List<EquipementDTO>> getAllEquipements() {
        List<EquipementDTO> equipements = equipementService.getAllEquipements();
        if(equipements.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(equipements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipementDTO> getEquipementById(@PathVariable Long id) {
        EquipementDTO equipement = equipementService.getEquipementById(id);
        return ResponseEntity.ok(equipement);
    }

    @PostMapping("/")
    public ResponseEntity<EquipementDTO> createEquipement(@RequestBody CreateEquipementDTO equipement) {
        EquipementDTO createdEquipement = equipementService.createEquipement(equipement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEquipement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipementDTO> updateEquipement(@RequestBody CreateEquipementDTO equipement, @PathVariable Long id) {
        EquipementDTO updatedEquipement = equipementService.updateEquipement(equipement, id);
        return ResponseEntity.ok(updatedEquipement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EquipementDTO> deleteEquipement(@PathVariable Long id) {
        EquipementDTO deletedEquipement = equipementService.deleteEquipement(id);
        return ResponseEntity.ok(deletedEquipement);
    }
}
