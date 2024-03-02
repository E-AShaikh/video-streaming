package com.videostreaming.uploadservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Service
public class UploadVidService {
    private final WebClient webClient;


    @Autowired
    public UploadVidService(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://video-storage-service:8060").build();
    }

    public boolean upload(String fileName, MultipartFile multipartFile) throws IOException {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("name", fileName);
        builder.part("file", multipartFile.getResource());

        String response = webClient.post()
                .uri("/videoDB")
                .accept(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(builder.build()))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        assert response != null;
        System.out.println(response);
        return response.equals("success");
    }
}



