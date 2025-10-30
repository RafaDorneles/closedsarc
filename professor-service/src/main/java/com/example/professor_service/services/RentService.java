package com.example.professor_service.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.createDTOs.CreateRentDTO;
import com.example.professor_service.clients.RentWebClient;
import com.example.professor_service.exceptions.ApiException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RentService {
    
    @Autowired
    private RentWebClient rentWebClient;

    public Flux<RentDTO> getAllRents() {
        return rentWebClient.getAllRents();
    }

    public Mono<RentDTO> getRentById(Long id) {
        return rentWebClient.getRentById(id);
    }

    public Mono<RentDTO> createRent(CreateRentDTO dto) {
        return rentWebClient.getAllRents()
                .filter(rent -> rent.getRentableItem().getId().equals(dto.getRentableItemId()))
                .filter(rent -> overlaps(rent.getInitialRentDate(), rent.getFinalRentDate(), dto.getInitialRentDate(), dto.getFinalRentDate()))
                .hasElements()
                .flatMap(conflictExists -> {
                    if (conflictExists) {
                        return Mono.error(new ApiException("Equipment already rented during this period.", HttpStatus.CONFLICT));
                    } else {
                        return rentWebClient.createRent(dto);
                    }
                });
    }

    public Mono<RentDTO> updateRent(Long id, CreateRentDTO dto){
        return rentWebClient.getRentById(id)
                .filter(rent -> overlaps(rent.getInitialRentDate(), rent.getFinalRentDate(), dto.getInitialRentDate(), dto.getFinalRentDate()))
                .hasElement()
                .flatMap(conflictExists -> {
                    if (conflictExists) {
                        return Mono.error(new ApiException("Equipment already rented during this period.", HttpStatus.CONFLICT));
                    } else {
                        return rentWebClient.createRent(dto);
                    }
                });
    }

    public Mono<RentDTO> deleteRent(Long id) {
        return rentWebClient.deleteRent(id);
    }

    private boolean overlaps(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }
}
