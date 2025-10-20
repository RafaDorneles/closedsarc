package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.AdminDTO;
import com.example.common.dtos.requestsDTO.AdminRequestDTO;

public interface IAdminService {
    List<AdminDTO> getAllAdmins();
    AdminDTO getAdminById(Long id);
    AdminDTO createAdmin(AdminRequestDTO dto);
    AdminDTO updateAdmin(AdminRequestDTO dto, Long id);
    AdminDTO deleteAdmin(Long id);
}
