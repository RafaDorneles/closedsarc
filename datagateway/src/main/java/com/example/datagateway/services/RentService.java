package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.createDTOs.CreateRentDTO;
import com.example.common.exceptions.ApiException;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.models.Course;
import com.example.common.models.Rent;
import com.example.common.models.Rentable;
import com.example.datagateway.repositories.ICourseRepository;
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
    private ICourseRepository courseRepository;

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
    public RentDTO createRent(CreateRentDTO rent) {
        Course course = courseRepository.findById(rent.getCourseId())
                .orElseThrow(() -> new ApiException("Course not found", HttpStatus.NOT_FOUND));

        Rentable rentableItem = rentableRepository.findById(rent.getRentableItemId())
                .orElseThrow(() -> new ApiException("Rentable item not found", HttpStatus.NOT_FOUND));

        Rent newRent = rentMapper.requestToEntity(course, rentableItem);
        course.addRent(newRent);
        rentableItem.addRent(newRent);

        return rentMapper.entityToDto(rentRepository.save(newRent));
    }

    @Override
    public RentDTO updateRent(CreateRentDTO rent, Long id) {
        Rent existingRent = rentRepository.findById(id)
                .orElseThrow(() -> new ApiException("Rent not found", HttpStatus.NOT_FOUND));

        Course oldCourse = existingRent.getCourse();
        Rentable oldRentable = existingRent.getRentableItem();

        Course newCourse = courseRepository.findById(rent.getCourseId())
                .orElseThrow(() -> new ApiException("Course not found", HttpStatus.NOT_FOUND));

        Rentable newRentable = rentableRepository.findById(rent.getRentableItemId())
                .orElseThrow(() -> new ApiException("Rentable item not found", HttpStatus.NOT_FOUND));
        
        oldCourse.removeRent(existingRent);
        oldRentable.removeRent(existingRent);
        newCourse.addRent(existingRent);
        newRentable.addRent(existingRent);
        return rentMapper.entityToDto(rentRepository.save(existingRent));
    }

    @Override
    public RentDTO deleteRent(Long id) {
        Rent rent = rentRepository.findById(id)
                .orElseThrow(() -> new ApiException("Rent not found", HttpStatus.NOT_FOUND));
        rentRepository.delete(rent);

        rent.getCourse().removeRent(rent);
        rent.getRentableItem().removeRent(rent);
        return rentMapper.entityToDto(rent);
    }
}
