package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.createDTOs.CreateRoomDTO;
import com.example.datagateway.exceptions.ApiException;
import com.example.common.mappers.interfaces.IRoomMapper;
import com.example.datagateway.repositories.IRoomRepository;
import com.example.datagateway.services.interfaces.IRoomService;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private IRoomMapper roomMapper;

    @Override
    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll().stream().map(roomMapper::entityToDto).toList();
    }

    @Override
    public RoomDTO getRoomById(Long id) {
        return roomRepository.findById(id).map(roomMapper::entityToDto).orElseThrow(() -> new ApiException("Room not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public RoomDTO createRoom(CreateRoomDTO room) {
        return roomMapper.entityToDto(roomRepository.save(roomMapper.requestToEntity(room)));
    }

    @Override
    public RoomDTO updateRoom(CreateRoomDTO room, Long id) {
        return roomRepository.findById(id)
                .map(existingRoom -> {
                    RoomDTO updatedRoom = roomMapper.entityToDto(roomRepository.save(roomMapper.requestToEntity(room)));
                    return updatedRoom;
                })
                .orElseThrow(() -> new ApiException("Room not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public RoomDTO deleteRoom(Long id) {
        RoomDTO roomDTO = roomRepository.findById(id).map(roomMapper::entityToDto)
                .orElseThrow(() -> new ApiException("Room not found", HttpStatus.NOT_FOUND));
        roomRepository.deleteById(id);
        return roomDTO;
    }
    
}
