package com.jmc;

import com.jmc.entities.User;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        User user = new User("tproykov", 20, LocalDate.now());
        Order order = new Order(20, LocalDate.now());

        dbContext.persist(user);

        User fromDb = dbContext.find(User.class, 1);

        System.out.println(fromDb.getUsername());






    }
}