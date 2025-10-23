package com.example.common.dtos;

import java.time.LocalDateTime;

import com.example.common.models.Rentable;
import com.example.common.models.Classroom;

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
    private Long classroomId;
    private Long rentableItemId;
    private LocalDateTime rentDate;
}
