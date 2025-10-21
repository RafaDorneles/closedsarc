package com.example.common.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import com.example.common.models.Rent;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentableDTO {

    private Long id;
    private List<Rent> rents;
}
