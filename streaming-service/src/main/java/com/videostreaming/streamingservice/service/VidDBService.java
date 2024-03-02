package com.videostreaming.streamingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.videostreaming.streamingservice.model.VidMetaDataDTO;

import java.util.List;

@Service
public class VidDBService {
    private final WebClient webClient;

    @Autowired
    public VidDBService(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://sql-service:8090").build();
    }

    public List<VidMetaDataDTO> getVidToDB() {
        return webClient.get()
                .uri("/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<VidMetaDataDTO>>() {
                })
                .block();
    }

}