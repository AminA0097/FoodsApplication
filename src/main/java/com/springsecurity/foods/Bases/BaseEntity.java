package com.springsecurity.foods.Bases;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Column(name = "created_by")
    private String created;
    @Column(name = "updated_by")
    private String updated;
    @Column(name = "deleted")
    private Integer deleted;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;
}
