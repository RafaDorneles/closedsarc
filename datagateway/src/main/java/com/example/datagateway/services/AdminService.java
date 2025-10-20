package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.AdminDTO;
import com.example.common.dtos.requestsDTO.AdminRequestDTO;
import com.example.common.exceptions.ApiException;
import com.example.common.mappers.AdminMapper;
import com.example.common.models.Admin;
import com.example.datagateway.repositories.IAdminRepository;
import com.example.datagateway.services.interfaces.IAdminService;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminRepository adminRepository;

    @Override
    public List<AdminDTO> getAllAdmins() {
        return adminRepository.findAll().stream().map(AdminMapper::entityToDto).toList();
    }

    @Override
    public AdminDTO getAdminById(Long id) {
        return adminRepository.findById(id).map(AdminMapper::entityToDto)
                .orElseThrow(() -> new ApiException("Admin not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public AdminDTO createAdmin(AdminRequestDTO dto) {
        Admin admin = AdminMapper.requestToEntity(dto);
        return AdminMapper.entityToDto(adminRepository.save(admin));
    }

    @Override
    public AdminDTO updateAdmin(AdminRequestDTO dto, Long id) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new ApiException("Admin not found", HttpStatus.NOT_FOUND));
        existingAdmin.setPassword(dto.getPassword());
        existingAdmin.setEmail(dto.getEmail());
        return AdminMapper.entityToDto(adminRepository.save(existingAdmin));
    }

    @Override
    public AdminDTO deleteAdmin(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ApiException("Admin not found", HttpStatus.NOT_FOUND));
        adminRepository.delete(admin);
        return AdminMapper.entityToDto(admin);
    }

}
