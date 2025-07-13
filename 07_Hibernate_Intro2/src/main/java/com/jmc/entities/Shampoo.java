package com.jmc.entities;

import jakarta.persistence.*;

import java.util.Set;

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

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "shampoo_id"),
               inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients;

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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
