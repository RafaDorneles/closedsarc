package com.example.common.mappers;

import org.springframework.stereotype.Component;

import com.example.common.dtos.AdminDTO;
import com.example.common.dtos.createDTOs.CreateAdminDTO;
import com.example.common.mappers.interfaces.IAdminMapper;
import com.example.common.models.Admin;

@Component
public class AdminMapper implements IAdminMapper{

    @Override
    public AdminDTO entityToDto(Admin admin) {
        if (admin == null) {
            return null;
        }

        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setPassword(admin.getPassword());
        dto.setEmail(admin.getEmail());

        return dto;
    }

    @Override
    public Admin requestToEntity(CreateAdminDTO dto) {
        if (dto == null) {
            return null;
        }

        Admin admin = new Admin();
        admin.setPassword(dto.getPassword());
        admin.setEmail(dto.getEmail());

        return admin;

    }
}
