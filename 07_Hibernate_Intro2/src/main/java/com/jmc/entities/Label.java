package com.jmc.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "labels")
public class Label extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "label")
    private Shampoo shampoo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
