package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.requestsDTO.RoomRequestDTO;

public interface IRoomService {
    List<RoomDTO> getAllRooms();
    RoomDTO getRoomById(Long id);
    RoomDTO createRoom(RoomRequestDTO room);
    RoomDTO updateRoom(RoomRequestDTO room, Long id);
    RoomDTO deleteRoom(Long id);
}
