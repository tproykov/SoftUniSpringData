package com.jmc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Shampoo> shampoos;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
