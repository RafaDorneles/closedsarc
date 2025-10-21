package com.example.common.mappers.interfaces;

import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.requestsDTO.RoomRequestDTO;
import com.example.common.models.Room;

public interface IRoomMapper {
    public RoomDTO entityToDto(Room room);
    public Room dtoToEntity(RoomDTO roomDTO);
    public Room requestToEntity(RoomRequestDTO roomRequestDTO);
}
