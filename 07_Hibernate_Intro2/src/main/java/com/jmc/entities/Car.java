package com.jmc.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue(value = "c")
public class Car extends Vehicle {

    private Integer seats;

    public Integer getSeas() {
        return seats;
    }

    public void setSeas(Integer seats) {
        this.seats = seats;
    }
}