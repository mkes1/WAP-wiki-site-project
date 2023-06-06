package com.uep.wap.dto;

public class SectionDTO {
    private long id;
    private String title;
    private long parentId;

    public SectionDTO() {
    }

    public SectionDTO(long id, String title, long parentId) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
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

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
