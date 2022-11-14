package com.damir.healthcare.entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "specialize")
public class Specialize {
    @Id
    @JoinColumn(table = "diseasetype", name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Doctor email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Doctor getEmail() {
        return email;
    }

    public void setEmail(Doctor email) {
        this.email = email;
    }

}