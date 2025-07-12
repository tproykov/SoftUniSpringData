package com.jmc;

import com.jmc.entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-emf");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Vehicle> query = em.createQuery("select v from Vehicle v", Vehicle.class);
        List<Vehicle> vehicles = query.getResultList();

        System.out.println(vehicles.size());


    }
}