package com.damir.healthcare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "discover")
public class Discover {
    @EmbeddedId
    public DiscoverID id;

    @Column(name = "first_enc_date", nullable = false)
    private LocalDate firstEncDate;

    public Country getCname() {
        return id.getCname();
    }

    public void setCname(Country cname) {
        this.id.setCname(cname);
    }

    public LocalDate getFirstEncDate() {
        return firstEncDate;
    }

    public void setFirstEncDate(LocalDate firstEncDate) {
        this.firstEncDate=firstEncDate;
    }

}
