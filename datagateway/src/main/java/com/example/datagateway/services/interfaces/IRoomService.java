package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.createDTOs.CreateRoomDTO;

public interface IRoomService {
    List<RoomDTO> getAllRooms();
    RoomDTO getRoomById(Long id);
    RoomDTO createRoom(CreateRoomDTO room);
    RoomDTO updateRoom(CreateRoomDTO room, Long id);
    RoomDTO deleteRoom(Long id);
}
