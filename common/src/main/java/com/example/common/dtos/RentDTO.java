package com.example.common.dtos;

import java.time.LocalDateTime;

import com.example.common.dtos.simpleDTOs.SimpleClassroomDTO;
import com.example.common.dtos.simpleDTOs.SimpleRentableDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentDTO {
    private Long id;
    private SimpleClassroomDTO classroom;
    private SimpleRentableDTO rentableItem;
    private LocalDateTime rentDate;
}
