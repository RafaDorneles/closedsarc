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

import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.createDTOs.CreateEquipamentDTO;
import com.example.datagateway.services.interfaces.IEquipamentService;

@RestController
@RequestMapping("/equipaments")
public class EquipamentController {
    
    @Autowired
    private IEquipamentService equipamentService;

    @GetMapping("/")
    public ResponseEntity<List<EquipamentDTO>> getAllEquipaments() {
        List<EquipamentDTO> equipaments = equipamentService.getAllEquipaments();
        if(equipaments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(equipaments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentDTO> getEquipamentById(@PathVariable Long id) {
        EquipamentDTO equipament = equipamentService.getEquipamentById(id);
        return ResponseEntity.ok(equipament);
    }

    @PostMapping("/")
    public ResponseEntity<EquipamentDTO> createEquipament(@RequestBody CreateEquipamentDTO equipament) {
        EquipamentDTO createdEquipament = equipamentService.createEquipament(equipament);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEquipament);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentDTO> updateEquipament(@RequestBody CreateEquipamentDTO equipament, @PathVariable Long id) {
        EquipamentDTO updatedEquipament = equipamentService.updateEquipament(equipament, id);
        return ResponseEntity.ok(updatedEquipament);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EquipamentDTO> deleteEquipament(@PathVariable Long id) {
        EquipamentDTO deletedEquipament = equipamentService.deleteEquipament(id);
        return ResponseEntity.ok(deletedEquipament);
    }
}
