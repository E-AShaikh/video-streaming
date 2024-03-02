package com.videostreaming.streamingservice.service;

import com.videostreaming.streamingservice.model.VidMetaDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class VidStorageService {

    private final WebClient webClient;

    @Autowired
    public VidStorageService(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://video-storage-service:8060").build();
    }

    public byte[] getVideo(VidMetaDataDTO vidMetaData) {
        return webClient.get()
                .uri("/videoDB/{name}", vidMetaData.getVidName())
                .accept(MediaType.APPLICATION_OCTET_STREAM)
                .retrieve()
                .bodyToMono(byte[].class)
                .block(); // Block to get the result synchronously (for demonstration purposes)
    }
}
