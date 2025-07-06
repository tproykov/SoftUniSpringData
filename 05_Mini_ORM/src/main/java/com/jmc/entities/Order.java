package com.jmc.entities;

import com.jmc.orm.annotations.Column;
import com.jmc.orm.annotations.Entity;
import com.jmc.orm.annotations.Id;
import java.time.Instant;

@Entity
public class Order {

    @Id
    @Column
    private int orderId;
    @Column
    private double amount;
    @Column
    private Instant createdAt;

    public Order(double amount, Instant createdAt) {
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
