package com.uep.wap.controller;

import com.uep.wap.dto.MediaFileDTO;
import com.uep.wap.service.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/media-files")
public class MediaFileController {

    private final MediaFileService mediaFileService;

    @Autowired
    public MediaFileController(MediaFileService mediaFileService) {
        this.mediaFileService = mediaFileService;
    }

    @PostMapping
    public MediaFileDTO uploadMediaFile(@RequestBody MediaFileDTO mediaFileDTO) {
        return mediaFileService.uploadMediaFile(mediaFileDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMediaFile(@PathVariable("id") long id) {
        mediaFileService.deleteMediaFile(id);
    }
}
