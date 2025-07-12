package com.jmc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Car extends Vehicle {

    private Integer seats;

    public Integer getSeas() {
        return seats;
    }

    public void setSeas(Integer seats) {
        this.seats = seats;
    }
}