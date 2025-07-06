package com.jmc.entities;

import com.jmc.orm.annotations.Column;
import com.jmc.orm.annotations.Entity;
import com.jmc.orm.annotations.Id;
import java.time.Instant;
import java.time.LocalDate;

@Entity(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "created_at")
    private LocalDate createdAt;

    public Order() {}

    public Order(double amount, LocalDate createdAt) {
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
