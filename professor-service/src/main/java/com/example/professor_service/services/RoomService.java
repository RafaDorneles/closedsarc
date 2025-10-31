package com.example.professor_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.dtos.RoomDTO;
import com.example.professor_service.clients.RoomWebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoomService {
    
    @Autowired
    private RoomWebClient roomWebClient;

    public Flux<RoomDTO> getAllRooms(){
        return roomWebClient.getAllRooms();
    }

    public Mono<RoomDTO> getRoomById(Long id){
        return roomWebClient.getRoomById(id);
    }
}
