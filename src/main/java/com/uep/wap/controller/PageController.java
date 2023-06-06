package com.uep.wap.controller;

import com.uep.wap.dto.PageDTO;
import com.uep.wap.service.PageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pages")
public class PageController {

    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public ResponseEntity<List<PageDTO>> getAllPages() {
        List<PageDTO> pages = pageService.getAllPages();
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageDTO> getPageById(@PathVariable long id) {
        PageDTO page = pageService.getPageById(id);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<PageDTO> createPage(@RequestBody PageDTO pageDTO) {
        PageDTO createdPage = pageService.createPage(pageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageDTO> updatePage(@PathVariable long id, @RequestBody PageDTO pageDTO) {
        PageDTO updatedPage = pageService.updatePage(id, pageDTO);
        return ResponseEntity.ok(updatedPage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(@PathVariable long id) {
        pageService.deletePage(id);
        return ResponseEntity.noContent().build();
    }
}
