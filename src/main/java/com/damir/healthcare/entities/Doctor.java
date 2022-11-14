package com.damir.healthcare.entities;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @JoinColumn(table = "users", referencedColumnName = "email")
    public String email;
    @Column(name = "degree", nullable = false, length = 20)
    private String degree;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //TODO [JPA Buddy] generate columns from DB
}