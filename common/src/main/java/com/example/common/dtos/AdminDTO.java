package com.example.common.dtos;

import com.example.common.models.Admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    
    private String password;
    private String email;

    public Admin toEntity(){    
        Admin admin = new Admin();
        admin.setEmail(this.email);
        admin.setPassword(this.password);
        return admin;
    }

    public AdminDTO toDTO(Admin admin){
        AdminDTO dto = new AdminDTO();
        dto.setEmail(admin.getEmail());
        dto.setPassword(admin.getPassword());
        return dto;
    }
    
}
