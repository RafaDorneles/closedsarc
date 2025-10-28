package com.example.common.mappers.interfaces;

import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.createDTOs.CreateRoomDTO;
import com.example.common.models.Room;

public interface IRoomMapper {
    public RoomDTO entityToDto(Room room);
    public Room requestToEntity(CreateRoomDTO createRoomDTO);
    
}
