package com.example.datagateway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dtos.ProfessorDTO;
import com.example.datagateway.services.interfaces.IProfessorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.common.dtos.createDTOs.CreateProfessorDTO;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private IProfessorService professorService;
    
    @GetMapping("/")
    public ResponseEntity<List<ProfessorDTO>> getAllProfessors() {
        List<ProfessorDTO> professors = professorService.getAllProfessors();
        if (professors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(professors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getProfessorById(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.getProfessorById(id));
    }

    @PostMapping("/")
    public ResponseEntity<ProfessorDTO> createProfessor(@RequestBody CreateProfessorDTO dto) {
        ProfessorDTO createdProfessor = professorService.createProfessor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfessor);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDTO> updateProfessor(@PathVariable Long id, @RequestBody CreateProfessorDTO dto) {
        return ResponseEntity.ok(professorService.updateProfessor(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfessorDTO> deleteProfessor(@PathVariable Long id){
        return ResponseEntity.ok(professorService.deleteProfessor(id));
    }
}
