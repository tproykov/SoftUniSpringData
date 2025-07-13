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
        em.persist(label);

        ProductionBatch batch = new ProductionBatch();
        batch.setDate(LocalDate.now());
        em.persist(batch);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Salt");
        em.persist(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Lavender");
        em.persist(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("Camomile");
        em.persist(ingredient3);

        Shampoo shampoo = new Shampoo();
        shampoo.setBrand("The best shampoo company");
        shampoo.setLabel(label);
        shampoo.setBatch(batch);
        shampoo.setIngredients(new HashSet<Ingredient>(List.of(ingredient1, ingredient2, ingredient3)));
        em.persist(shampoo);

        em.getTransaction().commit();

        // Clear the PC (Persistence context)
        em.clear();

        TypedQuery<Shampoo> shampooQuery = em.createQuery("select s from Shampoo s", Shampoo.class);
        List<Shampoo> shampoos = shampooQuery.getResultList();

        for (Shampoo s : shampoos) {
            System.out.printf("%s - %s - %s\n", s.getBrand(), s.getLabel().getName(), s.getBatch().getDate());
        }



        em.close();


    }
}