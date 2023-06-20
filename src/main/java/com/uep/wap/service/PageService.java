package com.uep.wap.service;

import com.uep.wap.dto.PageDTO;
import com.uep.wap.model.Page;
import com.uep.wap.model.Section;
import com.uep.wap.repository.PageRepository;
import com.uep.wap.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageService {

    private final PageRepository pageRepository;
    private final SectionRepository sectionRepository;

    public PageService(PageRepository pageRepository, SectionRepository sectionRepository) {
        this.pageRepository = pageRepository;
        this.sectionRepository = sectionRepository;
    }

    public List<PageDTO> getAllPages() {
        List<Page> pages = (List<Page>) pageRepository.findAll();
        return pages.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PageDTO getPageById(long id) {
        Page page = pageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid page id: " + id));
        return convertToDTO(page);
    }

    public PageDTO createPage(PageDTO pageDTO) {
        Section section = sectionRepository.findById(pageDTO.getSectionId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid section id: " + pageDTO.getSectionId()));

        Page page = convertToEntity(pageDTO);
        page.setSection(section);
        Page savedPage = pageRepository.save(page);
        return convertToDTO(savedPage);
    }

    public PageDTO updatePage(long id, PageDTO pageDTO) {
        Page existingPage = pageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid page id: " + id));

        Section section = sectionRepository.findById(pageDTO.getSectionId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid section id: " + pageDTO.getSectionId()));

        existingPage.setTitle(pageDTO.getTitle());
        existingPage.setContent(pageDTO.getContent());
        existingPage.setSection(section);

        Page updatedPage = pageRepository.save(existingPage);
        return convertToDTO(updatedPage);
    }

    public void deletePage(long id) {
        Page existingPage = pageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid page id: " + id));
        pageRepository.delete(existingPage);
    }

    private Page convertToEntity(PageDTO pageDTO) {
        Page page = new Page();
        page.setTitle(pageDTO.getTitle());
        page.setContent(pageDTO.getContent());
        Section section = new Section();
        section.setId(pageDTO.getSectionId());
        page.setSection(section);
        return page;
    }

    private PageDTO convertToDTO(Page page) {
        return new PageDTO(page.getId(), page.getTitle(), page.getContent(), page.getSection().getId(), page.getUrl());
    }
}
