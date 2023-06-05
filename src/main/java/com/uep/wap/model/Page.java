package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name = "pages")
public class Page {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "sectionId")
    private long sectionId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Page() {

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

    public Page(String title, String content, long sectionId) {
        this.title = title;
        this.content = content;
        this.sectionId = sectionId;
    }
}