package com.example.common.mappers;

import com.example.common.dtos.AdminDTO;
import com.example.common.dtos.requestsDTO.AdminRequestDTO;
import com.example.common.models.Admin;

public class AdminMapper {

    public static AdminDTO entityToDto(Admin admin) {
        if (admin == null) {
            return null;
        }

        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setPassword(admin.getPassword());
        dto.setEmail(admin.getEmail());

        return dto;
    }

    public static Admin dtoToEntity(AdminDTO dto) {
        if (dto == null) {
            return null;
        }

        Admin admin = new Admin();
        admin.setId(dto.getId());
        admin.setPassword(dto.getPassword());
        admin.setEmail(dto.getEmail());

        return admin;
    }

    public static Admin requestToEntity(AdminRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Admin admin = new Admin();
        admin.setPassword(dto.getPassword());
        admin.setEmail(dto.getEmail());

        return admin;

    }
}
