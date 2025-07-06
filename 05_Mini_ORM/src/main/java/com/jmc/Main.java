package com.jmc;

import com.jmc.entities.User;
import com.jmc.orm.EntityManager;
import com.jmc.orm.MyConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {

        User user = new User("tproykov", 20, LocalDate.now());
        // Order order = new Order(20, LocalDate.now());

        Connection connection = MyConnector.getConnection("mini_orm");

        EntityManager<User> userEm = new EntityManager<>(connection);
        // EntityManager<Order> orderEm = new EntityManager<>(connection);

        userEm.persist(user);
        // dbContext.persist(user);



        User fromDb = userEm.findFirst(User.class, "id = 1");

        // System.out.println(fromDb.getUsername());



    }
}