package com.jmc;

import com.jmc.entities.User;
import com.jmc.orm.MyConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {

        User user = new User("tproykov", 20, LocalDate.now());
        // Order order = new Order(20, LocalDate.now());

        Connection connection = MyConnector.getConnection("mini_orm");

        // dbContext.persist(user);

        // User fromDb = dbContext.find(User.class, 1);

        // System.out.println(fromDb.getUsername());






    }
}