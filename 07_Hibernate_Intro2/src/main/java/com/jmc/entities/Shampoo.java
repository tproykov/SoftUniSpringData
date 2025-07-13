package com.jmc.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "shampoos")
public class Shampoo extends BaseEntity {

    @Column(name = "brand")
    private String brand;

    @OneToOne(optional = false)
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private Label label;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_id", nullable = false, referencedColumnName = "id")
    private ProductionBatch batch;

    

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

    public ProductionBatch getBatch() {
        return batch;
    }

    public void setBatch(ProductionBatch productionBatch) {
        this.batch = productionBatch;
    }
}
