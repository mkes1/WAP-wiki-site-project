package com.uep.wap.service;

import com.uep.wap.dto.MediaFileDTO;
import com.uep.wap.model.MediaFile;
import com.uep.wap.repository.MediaFileRepository;
import org.springframework.stereotype.Service;

@Service
public class MediaFileService {

    private final MediaFileRepository mediaFileRepository;

    public MediaFileService(MediaFileRepository mediaFileRepository) {
        this.mediaFileRepository = mediaFileRepository;
    }

    public MediaFileDTO uploadMediaFile(MediaFileDTO mediaFileDTO) {
        MediaFile mediaFile = convertToEntity(mediaFileDTO);
        MediaFile savedMediaFile = mediaFileRepository.save(mediaFile);
        return convertToDTO(savedMediaFile);
    }

    public void deleteMediaFile(long id) {
        MediaFile existingMediaFile = mediaFileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid media file id: " + id));
        mediaFileRepository.delete(existingMediaFile);
    }

    private MediaFile convertToEntity(MediaFileDTO mediaFileDTO) {
        MediaFile mediaFile = new MediaFile();
        mediaFile.setId(mediaFileDTO.getId());
        mediaFile.setFilename(mediaFileDTO.getFilename());
        mediaFile.setFiletype(mediaFileDTO.getFiletype());
        mediaFile.setUrl(mediaFileDTO.getUrl());
        mediaFile.setSectionId(mediaFileDTO.getSectionId());
        return mediaFile;
    }

    private MediaFileDTO convertToDTO(MediaFile mediaFile) {
        MediaFileDTO mediaFileDTO = new MediaFileDTO();
        mediaFileDTO.setId(mediaFile.getId());
        mediaFileDTO.setFilename(mediaFile.getFilename());
        mediaFileDTO.setFiletype(mediaFile.getFiletype());
        mediaFileDTO.setUrl(mediaFile.getUrl());
        mediaFileDTO.setSectionId(mediaFile.getSectionId());
        return mediaFileDTO;
    }
}
