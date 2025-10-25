package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.AdminDTO;
import com.example.common.dtos.createDTOs.CreateAdminDTO;
import com.example.common.exceptions.ApiException;
import com.example.common.mappers.interfaces.IAdminMapper;
import com.example.common.models.Admin;
import com.example.datagateway.repositories.IAdminRepository;
import com.example.datagateway.services.interfaces.IAdminService;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminRepository adminRepository;

    @Autowired
    private IAdminMapper adminMapper;

    @Override
    public List<AdminDTO> getAllAdmins() {
        return adminRepository.findAll().stream().map(adminMapper::entityToDto).toList();
    }

    @Override
    public AdminDTO getAdminById(Long id) {
        return adminRepository.findById(id).map(adminMapper::entityToDto)
                .orElseThrow(() -> new ApiException("Admin not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public AdminDTO createAdmin(CreateAdminDTO dto) {
        Admin admin = adminMapper.requestToEntity(dto);
        return adminMapper.entityToDto(adminRepository.save(admin));
    }

    @Override
    public AdminDTO updateAdmin(CreateAdminDTO dto, Long id) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new ApiException("Admin not found", HttpStatus.NOT_FOUND));
        existingAdmin.setPassword(dto.getPassword());
        existingAdmin.setEmail(dto.getEmail());
        return adminMapper.entityToDto(adminRepository.save(existingAdmin));
    }

    @Override
    public AdminDTO deleteAdmin(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ApiException("Admin not found", HttpStatus.NOT_FOUND));
        adminRepository.delete(admin);
        return adminMapper.entityToDto(admin);
    }

}
