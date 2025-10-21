package com.example.common.mappers.interfaces;

import com.example.common.dtos.AdminDTO;
import com.example.common.dtos.requestsDTO.AdminRequestDTO;
import com.example.common.models.Admin;

public interface IAdminMapper {
    public AdminDTO entityToDto(Admin admin);
    public Admin dtoToEntity(AdminDTO adminDTO);
    public Admin requestToEntity(AdminRequestDTO adminRequestDTO);
}
