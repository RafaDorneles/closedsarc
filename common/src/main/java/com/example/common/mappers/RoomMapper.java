package com.example.common.mappers;

import java.util.ArrayList;

import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.requestsDTO.RoomRequestDTO;
import com.example.common.mappers.interfaces.IRoomMapper;
import com.example.common.models.Room;

public class RoomMapper implements IRoomMapper {

    @Override
    public RoomDTO entityToDto(Room room) {
        if (room == null) {
            return null;
        }

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setNumber(room.getNumber());
        roomDTO.setRents(room.getRents());
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
        room.setRents(roomDTO.getRents());
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
        room.setRents(new ArrayList<>());
        return room;
    }
    
}
