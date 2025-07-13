package com.jmc;

import com.jmc.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-emf");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Bike bike = new Bike();
        bike.setModel("BMX");
        em.persist(bike);

        Car car = new Car();
        car.setModel("BMW");
        car.setSeas(4);
        car.setFuelType("Gasoline");
        em.persist(car);

        Plane plane = new Plane();
        plane.setModel("Boeing 747");
        plane.setPassengerCapacity(1000);
        plane.setFuelType("Gasoline");
        em.persist(plane);

        Truck truck = new Truck();
        truck.setModel("Volvo 140");
        truck.setLoadCapacity(2.5);
        em.persist(truck);

        em.getTransaction().commit();


        TypedQuery<Vehicle> query = em.createQuery("select v from Vehicle v", Vehicle.class);
        List<Vehicle> vehicles = query.getResultList();

        System.out.println(vehicles.size());

        // ==============================================

        em.getTransaction().begin();

        Label label = new Label();
        label.setName("Smooth and long hair");

        ProductionBatch batch = new ProductionBatch();
        batch.setDate(LocalDate.now());

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Salt");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Lavender");

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("Camomile");

        Shampoo shampoo = new Shampoo();
        shampoo.setBrand("The best shampoo company");
        shampoo.setLabel(label);
        shampoo.setBatch(batch);
        shampoo.setIngredients(new HashSet<Ingredient>(List.of(ingredient1, ingredient2, ingredient3)));
        
        em.persist(shampoo);


        em.getTransaction().commit();
        em.close();


    }
}