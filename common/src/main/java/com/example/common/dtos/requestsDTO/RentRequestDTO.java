package com.example.common.dtos.requestsDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentRequestDTO {
    private Long classroomId;
    private Long rentableItemId;
}
