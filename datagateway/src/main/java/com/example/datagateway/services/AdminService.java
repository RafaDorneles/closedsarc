package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.AdminDTO;
import com.example.common.exceptions.ApiException;
import com.example.common.models.Admin;
import com.example.datagateway.repositories.IAdminRepository;
import com.example.datagateway.services.interfaces.IAdminService;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminRepository adminRepository; 

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new ApiException("Admin not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Admin createAdmin(AdminDTO dto) {
        Admin admin = dto.toEntity();
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        Admin existingAdmin = adminRepository.findById(admin.getId())
                .orElseThrow(() -> new ApiException("Admin not found", HttpStatus.NOT_FOUND));
        existingAdmin.setPassword(admin.getPassword());
        existingAdmin.setEmail(admin.getEmail());
        return adminRepository.save(existingAdmin);
    }

    @Override
    public Admin deleteAdmin(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ApiException("Admin not found", HttpStatus.NOT_FOUND));
        adminRepository.delete(admin);
        return admin;
    }

}
