package com.damir.healthcare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public
class DiscoverID implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cname", nullable = false)
    private Country cname;

    @Column(name = "disease_code", nullable = false)
    @JoinColumn(name = "disease_code")
    public Long disease_code;

    public Country getCname() {
        return cname;
    }

    public void setCname(Country cname) {
        this.cname = cname;
    }

}
