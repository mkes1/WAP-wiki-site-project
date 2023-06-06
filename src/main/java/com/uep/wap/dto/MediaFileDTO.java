package com.uep.wap.dto;


public class MediaFileDTO {

    private long id;

    private String filename;

    private String filetype;

    private String url;


    private long sectionId;



    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

}
