package com.damir.healthcare.entities;

import javax.persistence.*;

@Entity
@Table(name = "publicservant")
public class Statistician {
    @Id
    @JoinColumn(table = "users", referencedColumnName = "email")
    public String email;
    @Column(name = "department", nullable = false, length = 50)
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String id) {
    this.email=id;
    }

    //TODO [JPA Buddy] generate columns from DB
}