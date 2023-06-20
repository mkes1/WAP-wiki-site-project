package com.uep.wap.dto;

public class PageDTO {
    private long id;
    private String title;
    private String content;
    private long sectionId;

    private String url;

    public PageDTO() {
    }

    public PageDTO(long id, String title, String content, long sectionId, String url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.sectionId = sectionId;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }
}
