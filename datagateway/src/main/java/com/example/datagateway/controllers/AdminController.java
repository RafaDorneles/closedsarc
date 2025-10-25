package com.example.datagateway.controllers;

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
import java.util.List;

import com.example.common.dtos.AdminDTO;
import com.example.common.dtos.createDTOs.CreateAdminDTO;
import com.example.datagateway.services.interfaces.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    public AdminController(IAdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        List<AdminDTO> admins = adminService.getAllAdmins();
        if(admins.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable Long id) {
        AdminDTO admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

    @PostMapping("/")
    public ResponseEntity<AdminDTO> createAdmin(@RequestBody CreateAdminDTO dto) {
        AdminDTO createdAdmin = adminService.createAdmin(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminDTO> updateAdmin(@RequestBody CreateAdminDTO dto, @PathVariable Long id) {
        AdminDTO updatedAdmin = adminService.updateAdmin(dto, id);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdminDTO> deleteAdmin(@PathVariable Long id) {
        AdminDTO deletedAdmin = adminService.deleteAdmin(id);
        return ResponseEntity.ok(deletedAdmin);
    }

}
