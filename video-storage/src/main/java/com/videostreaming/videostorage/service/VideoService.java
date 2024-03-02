package com.videostreaming.videostorage.service;

import com.videostreaming.videostorage.model.Video;
import com.videostreaming.videostorage.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class VideoService  {

    @Autowired
    private VideoRepository vRepo;

    public Video getVideo(String name) {
        if (!vRepo.existsByName(name))
            return null;
        return vRepo.findByName(name);
    }

    public void storeVideo(MultipartFile videoFile, String name) throws IOException {
        if (!vRepo.existsByName(name)) {
            Video vid = new Video(name, videoFile.getBytes());
            vRepo.save(vid);
        }
    }
}
