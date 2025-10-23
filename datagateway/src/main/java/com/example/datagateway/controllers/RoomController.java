package com.example.datagateway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dtos.RoomDTO;
import com.example.datagateway.services.interfaces.IRoomService;

@RestController
public class RoomController {
    
    @Autowired
    private IRoomService roomService;

    @GetMapping("/")
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    


}
