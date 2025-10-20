package com.example.datagateway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.models.Equipament;
import com.example.datagateway.services.interfaces.IEquipamentService;

@RestController
@RequestMapping("/equipament")
public class EquipamentController {
    
    @Autowired
    private IEquipamentService equipamentService;

    @GetMapping("/")
    public ResponseEntity<List<Equipament>> getAllEquipaments() {
        List<Equipament> equipaments = equipamentService.getAllEquipaments();
        if(equipaments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(equipaments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipament> getEquipamentById(@PathVariable Long id) {
        Equipament equipament = equipamentService.getEquipamentById(id);
        return ResponseEntity.ok(equipament);
    }

    @PostMapping("/")
    public ResponseEntity<Equipament> createEquipament(@RequestBody Equipament equipament) {
        Equipament createdEquipament = equipamentService.createEquipament(equipament);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEquipament);
    }

    @PutMapping("/")
    public ResponseEntity<Equipament> updateEquipament(@RequestBody Equipament equipament) {
        Equipament updatedEquipament = equipamentService.updateEquipament(equipament);
        return ResponseEntity.ok(updatedEquipament);
    }
    

}
