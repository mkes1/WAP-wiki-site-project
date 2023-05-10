package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name="sections")
public class Section{
    @Id
    @Column(name ="id")
    private long id;
    @Column(name ="title")
    private String title;
    @Column(name ="parentId")
    private long parentId;

}
