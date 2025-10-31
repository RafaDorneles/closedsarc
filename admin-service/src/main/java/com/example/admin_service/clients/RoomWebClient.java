package com.example.admin_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.admin_service.exceptions.RemoteApiException;
import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.createDTOs.CreateRoomDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RoomWebClient {
    
    @Autowired
    private WebClient webClient;

    public Flux<RoomDTO> getAllRooms() {
        return webClient.get()
                .uri("/rooms/")
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToFlux(RoomDTO.class);
    }

    public Mono<RoomDTO> getRoomById(Long id) {
        return webClient.get()
                .uri("/rooms/{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToMono(RoomDTO.class);
    }

    public Mono<RoomDTO> createRoom(CreateRoomDTO dto) {
        return webClient.post()
                .uri("/rooms/")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(RoomDTO.class);
    }

    public Mono<RoomDTO> updateRoom(Long id, CreateRoomDTO dto) {
        return webClient.put()
                .uri("/rooms/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(RoomDTO.class);
    }

    public Mono<RoomDTO> deleteRoom(Long id) {
        return webClient.delete()
                .uri("/rooms/{id}", id)
                .retrieve()
                .bodyToMono(RoomDTO.class);
    }
}
