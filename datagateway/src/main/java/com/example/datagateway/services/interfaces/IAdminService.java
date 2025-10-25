package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.AdminDTO;
import com.example.common.dtos.createDTOs.CreateAdminDTO;

public interface IAdminService {
    List<AdminDTO> getAllAdmins();
    AdminDTO getAdminById(Long id);
    AdminDTO createAdmin(CreateAdminDTO dto);
    AdminDTO updateAdmin(CreateAdminDTO dto, Long id);
    AdminDTO deleteAdmin(Long id);
}
