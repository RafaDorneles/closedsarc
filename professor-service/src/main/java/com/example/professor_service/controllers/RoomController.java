package com.example.professor_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dtos.RoomDTO;
import com.example.professor_service.services.RoomService;

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
}
