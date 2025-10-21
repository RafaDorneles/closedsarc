package com.example.common.dtos;

import java.util.List;

import com.example.common.models.Rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private Long id;
    private Integer capacity;
    private Integer number;
    private List<Rent> rents;

}
