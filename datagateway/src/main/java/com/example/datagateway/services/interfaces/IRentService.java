package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.requestsDTO.RentRequestDTO;

public interface IRentService {
    List<RentDTO> getAllRents();
    RentDTO getRentById(Long id);
    RentDTO createRent(RentRequestDTO rent);
    RentDTO updateRent(RentRequestDTO rent, Long id);
    RentDTO deleteRent(Long id);
}
