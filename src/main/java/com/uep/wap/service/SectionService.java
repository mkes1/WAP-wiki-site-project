package com.uep.wap.service;

import com.uep.wap.dto.SectionDTO;
import com.uep.wap.model.Section;
import com.uep.wap.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public List<SectionDTO> getAllSections() {
        List<Section> sections = (List<Section>) sectionRepository.findAll();
        return sections.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SectionDTO getSectionById(long id) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid section id: " + id));
        return convertToDTO(section);
    }

    public SectionDTO createSection(SectionDTO sectionDTO) {
        Section section = convertToEntity(sectionDTO);
        Section savedSection = sectionRepository.save(section);
        return convertToDTO(savedSection);
    }

    public SectionDTO updateSection(long id, SectionDTO sectionDTO) {
        Section existingSection = sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid section id: " + id));

        updateEntityWithDTO(existingSection, sectionDTO);
        Section updatedSection = sectionRepository.save(existingSection);
        return convertToDTO(updatedSection);
    }

    public void deleteSection(long id) {
        Section existingSection = sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid section id: " + id));
        sectionRepository.delete(existingSection);
    }

    private Section convertToEntity(SectionDTO sectionDTO) {
        Section section = new Section();
        section.setId(sectionDTO.getId());
        section.setTitle(sectionDTO.getTitle());
        section.setParentId(sectionDTO.getParentId());
        return section;
    }

    private SectionDTO convertToDTO(Section section) {
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(section.getId());
        sectionDTO.setTitle(section.getTitle());
        sectionDTO.setParentId(section.getParentId());
        return sectionDTO;
    }

    private void updateEntityWithDTO(Section section, SectionDTO sectionDTO) {
        section.setTitle(sectionDTO.getTitle());
        section.setParentId(sectionDTO.getParentId());
    }
}