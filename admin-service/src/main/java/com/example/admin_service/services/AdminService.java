package com.example.admin_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin_service.clients.AdminWebClient;
import com.example.common.dtos.AdminDTO;
import com.example.common.dtos.createDTOs.CreateAdminDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AdminService {
    
    @Autowired
    AdminWebClient adminWebClient;

    public Flux<AdminDTO> getAllAdmins() {
        return adminWebClient.getAllAdmins();
    }

    public Mono<AdminDTO> getAdminById(Long id) {
        return adminWebClient.getAdminById(id);
    }

    public Mono<AdminDTO> createAdmin(CreateAdminDTO dto) {
        return adminWebClient.createAdmin(dto);
    }

    public Mono<AdminDTO> updateAdmin(Long id, CreateAdminDTO dto){
        return adminWebClient.updateAdmin(id, dto);
    }

    public Mono<AdminDTO> deleteAdmin(Long id) {
        return adminWebClient.deleteAdmin(id);
    }
}
