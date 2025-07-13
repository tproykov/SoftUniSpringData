package com.jmc.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "shampoos")
public class Shampoo extends BaseEntity {

    @Column(name = "brand")
    private String brand;

    @OneToOne
    @JoinColumn(name = "label_id", unique = true)
    private Label label;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private ProductionBatch productionBatch;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public ProductionBatch getProductionBatch() {
        return productionBatch;
    }

    public void setProductionBatch(ProductionBatch productionBatch) {
        this.productionBatch = productionBatch;
    }
}
