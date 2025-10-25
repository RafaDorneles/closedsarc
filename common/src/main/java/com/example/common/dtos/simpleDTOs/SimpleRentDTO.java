package com.example.common.dtos.simpleDTOs;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleRentDTO {
    private Long id;
    private Long classroomId;
    private Long rentableItemId;
    private LocalDateTime rentDate;
}
