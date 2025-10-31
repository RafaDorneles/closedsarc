package com.example.admin_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin_service.clients.RoomWebClient;
import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.createDTOs.CreateRoomDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoomService {
    
    @Autowired
    RoomWebClient roomWebClient;

    public Flux<RoomDTO> getAllRooms() {
        return roomWebClient.getAllRooms();
    }

    public Mono<RoomDTO> getRoomById(Long id) {
        return roomWebClient.getRoomById(id);
    }

    public Mono<RoomDTO> createRoom(CreateRoomDTO dto) {
        return roomWebClient.createRoom(dto);
    }

    public Mono<RoomDTO> updateRoom(Long id, CreateRoomDTO dto){
        return roomWebClient.updateRoom(id, dto);
    }

    public Mono<RoomDTO> deleteRoom(Long id) {
        return roomWebClient.deleteRoom(id);
    }
}
