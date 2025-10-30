package com.example.admin_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin_service.services.RoomService;
import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.createDTOs.CreateRoomDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    
    @Autowired
    private RoomService roomService;

    @GetMapping("/")
    public Flux<RoomDTO> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Mono<RoomDTO> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }
    
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RoomDTO> createRoom(@RequestBody CreateRoomDTO dto) {
        return roomService.createRoom(dto);
    }
    
    @PutMapping("/{id}")
    public Mono<RoomDTO> updateRoom(@PathVariable Long id, @RequestBody CreateRoomDTO dto) {
        return roomService.updateRoom(id, dto);
    }

    @DeleteMapping("/{id}")
    public Mono<RoomDTO> deleteRoom(@PathVariable Long id) {
        return roomService.deleteRoom(id);
    }
}
