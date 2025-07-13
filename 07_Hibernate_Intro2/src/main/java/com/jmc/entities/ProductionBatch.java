package com.jmc.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "batches")
public class ProductionBatch extends BaseEntity{

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "batch", targetEntity = Shampoo.class, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Shampoo> shampoos;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
