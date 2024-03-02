package com.videostreaming.streamingservice.controller;

import com.videostreaming.streamingservice.service.VidDBService;
import com.videostreaming.streamingservice.model.VidMetaDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.videostreaming.streamingservice.service.VidStorageService;

import java.util.Base64;
import java.util.List;

@Controller
public class StreamingController {
    private final VidDBService vidDBService;
    private final VidStorageService vidStorageService;

    public StreamingController(VidDBService vidDBService, VidStorageService vidStorageService) {
        this.vidStorageService = vidStorageService;
        this.vidDBService = vidDBService;
    }

    @GetMapping(value = {"/play/{id}", "/play", "/"})
    public String play(@PathVariable(required = false) Integer id, Model model) {
        List<VidMetaDataDTO> list = vidDBService.getVidToDB();
        VidMetaDataDTO selectedVideo;
        if (id == null)
            selectedVideo = list.get(0);
        else
            selectedVideo = list.get(list.indexOf(new VidMetaDataDTO(id)));

        byte[] videoContent = vidStorageService.getVideo(selectedVideo);

        model.addAttribute("videos", list);
        model.addAttribute("selected", selectedVideo);
        model.addAttribute("base64EncodedVideo", Base64.getEncoder().encodeToString(videoContent));
        return "video";
    }

}
