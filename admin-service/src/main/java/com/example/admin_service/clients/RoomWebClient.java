package com.example.admin_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.common.dtos.RoomDTO;
import com.example.common.dtos.createDTOs.CreateRoomDTO;
import com.example.common.exceptions.ApiException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RoomWebClient {
    
    @Autowired
    private WebClient webClient;

    public Flux<RoomDTO> getAllRooms() {
        return webClient.get()
                .uri("/rooms")
                .retrieve()
                .bodyToFlux(RoomDTO.class)
                .onErrorResume(WebClientResponseException.class, ex -> {
                    if (ex.getStatusCode() == HttpStatus.NOT_FOUND)
                        return Flux.empty();
                    return Flux.error(ex);
                });
    }

    public Mono<RoomDTO> getRoomById(Long id) {
        return webClient.get()
                .uri("/rooms/{id}", id)
                .retrieve()
                .bodyToMono(RoomDTO.class)
                .onErrorResume(WebClientResponseException.class, ex ->
                        Mono.error(new ApiException("Error while getting room", HttpStatus.NOT_FOUND))
                );
    }

    public Mono<RoomDTO> createRoom(CreateRoomDTO dto) {
        return webClient.post()
                .uri("/rooms")
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
