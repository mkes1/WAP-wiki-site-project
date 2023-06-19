package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name = "media-files")
public class MediaFile {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "filename")
    private String filename;

    @Column(name = "filetype")
    private String filetype;

    @Column(name = "url")
    private String url;

    @Column(name = "sectionId")
    private long sectionId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public MediaFile() {

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

    public MediaFile(String filename, String filetype, String url, long sectionId) {
        this.filename = filename;
        this.filetype = filetype;
        this.url = url;
        this.sectionId = sectionId;
    }
}
