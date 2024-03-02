package com.videostreaming.sqldatabase.controller;


import com.videostreaming.sqldatabase.model.VidMetaData;
import com.videostreaming.sqldatabase.service.VidMetaDataService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VidMetaDataContoller {
    private final VidMetaDataService vidMetaDataService;

    public VidMetaDataContoller(VidMetaDataService vidMetaDataService) {
        this.vidMetaDataService = vidMetaDataService;
    }

    @GetMapping("/")
    public List<VidMetaData> getVideos() {
        return vidMetaDataService.getAllVideos();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addVid(@RequestBody VidMetaData vidMetaData) {
        VidMetaData savedVidMetaData = vidMetaDataService.addVid(vidMetaData);
        return savedVidMetaData != null;
    }
}
