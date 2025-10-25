package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.createDTOs.CreateRentDTO;

public interface IRentService {
    List<RentDTO> getAllRents();
    RentDTO getRentById(Long id);
    RentDTO createRent(CreateRentDTO rent);
    RentDTO updateRent(CreateRentDTO rent, Long id);
    RentDTO deleteRent(Long id);
}
