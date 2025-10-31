package com.example.common.dtos.createDTOs;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentDTO {
    private Long courseId;
    private Long rentableItemId;
    private LocalDateTime initialRentDate;
    private LocalDateTime finalRentDate;
}
