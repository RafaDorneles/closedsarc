package com.example.common.mappers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.requestsDTO.RoomRequestDTO;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.mappers.interfaces.IRoomMapper;
import com.example.common.models.Room;

@Component
public class RoomMapper implements IRoomMapper {

    @Autowired
    private IRentMapper rentMapper;

    @Override
    public RoomDTO entityToDto(Room room) {
        if (room == null) {
            return null;
        }

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setNumber(room.getNumber());
        roomDTO.setRents(room.getRents().stream()
                .map(rentMapper::entityToDto)
                .toList());
        return roomDTO;
    }

    @Override
    public Room dtoToEntity(RoomDTO roomDTO) {
        if (roomDTO == null) {
            return null;
        }

        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setNumber(roomDTO.getNumber());
        room.setCapacity(roomDTO.getCapacity());
        return room;
    }

    @Override
    public Room requestToEntity(RoomRequestDTO roomRequestDTO) {
        if (roomRequestDTO == null) {
            return null;
        }

        Room room = new Room();
        room.setNumber(roomRequestDTO.getNumber());
        room.setCapacity(roomRequestDTO.getCapacity());
        return room;
    }
    
}
