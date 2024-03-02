package com.videostreaming.sqldatabase.service;

import com.videostreaming.sqldatabase.model.VidMetaData;
import com.videostreaming.sqldatabase.repository.VidMetaDataRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class VidMetaDataService {
    private final VidMetaDataRepository vidMetaDataRepository;

    public VidMetaDataService(VidMetaDataRepository vidMetaDataRepository) {
        this.vidMetaDataRepository = vidMetaDataRepository;
    }

    public List<VidMetaData> getAllVideos() {
        return vidMetaDataRepository.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public VidMetaData addVid(VidMetaData vidMetaData) {
        return vidMetaDataRepository.save(vidMetaData);
    }
}
