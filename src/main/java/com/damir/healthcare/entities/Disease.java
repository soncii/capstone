package com.damir.healthcare.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disease")
public class Disease {
    @Id
    @Column(name = "disease_code", nullable = false, length = 50)
    private String id;

    @Column(name = "pathogen", nullable = false, length = 20)
    private String pathogen;

    @Column(name = "description", nullable = false, length = 140)
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPathogen() {
        return pathogen;
    }

    public void setPathogen(String pathogen) {
        this.pathogen = pathogen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}