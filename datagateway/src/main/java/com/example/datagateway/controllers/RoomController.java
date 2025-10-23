package com.example.datagateway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.requestsDTO.RoomRequestDTO;
import com.example.datagateway.services.interfaces.IRoomService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class RoomController {
    
    @Autowired
    private IRoomService roomService;

    @GetMapping("/")
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        List<RoomDTO> rooms = roomService.getAllRooms();
        if(rooms.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @PostMapping("/")
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomRequestDTO room) {
        return ResponseEntity.ok(roomService.createRoom(room));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomRequestDTO room, @PathVariable Long id) {
        return ResponseEntity.ok(roomService.updateRoom(room, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoomDTO> deleteRoom(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.deleteRoom(id));
    }

}
