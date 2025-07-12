package com.jmc;

import com.jmc.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

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




        TypedQuery<Vehicle> query = em.createQuery("select v from Vehicle v", Vehicle.class);
        List<Vehicle> vehicles = query.getResultList();

        System.out.println(vehicles.size());


    }
}