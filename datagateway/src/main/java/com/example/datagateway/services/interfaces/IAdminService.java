package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.AdminDTO;
import com.example.common.models.Admin;

public interface IAdminService {
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
    Admin createAdmin(AdminDTO dto);
    Admin updateAdmin(Admin admin);
    Admin deleteAdmin(Long id);
}
