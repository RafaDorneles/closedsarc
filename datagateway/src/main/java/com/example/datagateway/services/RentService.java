package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.requestsDTO.RentRequestDTO;
import com.example.common.exceptions.ApiException;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.models.Classroom;
import com.example.common.models.Rent;
import com.example.common.models.Rentable;
import com.example.datagateway.repositories.IClassroomRepository;
import com.example.datagateway.repositories.IRentRepository;
import com.example.datagateway.repositories.IRentableRepository;
import com.example.datagateway.services.interfaces.IRentService;

@Service
public class RentService implements IRentService {

    @Autowired
    private IRentRepository rentRepository;

    @Autowired
    private IRentMapper rentMapper;

    @Autowired
    private IClassroomRepository classroomRepository;

    @Autowired
    private IRentableRepository rentableRepository;

    @Override
    public List<RentDTO> getAllRents() {
        return rentRepository.findAll().stream().map(rentMapper::entityToDto).toList();
    }

    @Override
    public RentDTO getRentById(Long id) {
        return rentRepository.findById(id)
                .map(rentMapper::entityToDto)
                .orElseThrow(() -> new ApiException("Rent not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public RentDTO createRent(RentRequestDTO rent) {
        Classroom classroom = classroomRepository.findById(rent.getClassroomId())
                .orElseThrow(() -> new ApiException("Classroom not found", HttpStatus.NOT_FOUND));

        Rentable rentableItem = rentableRepository.findById(rent.getRentableItemId())
                .orElseThrow(() -> new ApiException("Rentable item not found", HttpStatus.NOT_FOUND));

        return rentMapper.entityToDto(rentRepository.save(rentMapper.requestToEntity(classroom, rentableItem)));
    }

    @Override
    public RentDTO updateRent(RentRequestDTO rent, Long id) {
        Rent existingRent = rentRepository.findById(id)
                .orElseThrow(() -> new ApiException("Rent not found", HttpStatus.NOT_FOUND));

        Classroom classroom = classroomRepository.findById(rent.getClassroomId())
                .orElseThrow(() -> new ApiException("Classroom not found", HttpStatus.NOT_FOUND));

        Rentable rentableItem = rentableRepository.findById(rent.getRentableItemId())
                .orElseThrow(() -> new ApiException("Rentable item not found", HttpStatus.NOT_FOUND));
        
        existingRent.setClassroom(classroom);
        existingRent.setRentableItem(rentableItem);
        return rentMapper.entityToDto(rentRepository.save(existingRent));
    }

    @Override
    public RentDTO deleteRent(Long id) {
        Rent rent = rentRepository.findById(id)
                .orElseThrow(() -> new ApiException("Rent not found", HttpStatus.NOT_FOUND));
        rentRepository.delete(rent);
        return rentMapper.entityToDto(rent);
    }
}
