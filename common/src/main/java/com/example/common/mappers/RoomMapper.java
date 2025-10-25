package com.example.common.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.createDTOs.CreateRoomDTO;
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
                .map(rentMapper::entityToSimpleDto)
                .toList());
        return roomDTO;
    }

    @Override
    public Room requestToEntity(CreateRoomDTO createRoomDTO) {
        if (createRoomDTO == null) {
            return null;
        }

        Room room = new Room();
        room.setNumber(createRoomDTO.getNumber());
        room.setCapacity(createRoomDTO.getCapacity());
        return room;
    }
    
}
