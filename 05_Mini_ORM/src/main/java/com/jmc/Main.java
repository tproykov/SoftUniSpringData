package com.jmc;

import com.jmc.entities.Order;
import com.jmc.entities.User;
import com.jmc.orm.EntityManager;
import com.jmc.orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        User user = new User("tproykov", 20, LocalDate.now());
        Order order = new Order(20, LocalDate.now());

        Connection connection = MyConnector.getConnection("mini_orm");

        EntityManager<User> userEm = new EntityManager<>(connection);
        EntityManager<Order> orderEm = new EntityManager<>(connection);

        // userEm.persist(user);
        // orderEm.persist(order);

        User fromDb = userEm.findFirst(User.class, "id = 1");
        // User fromDb2 = userEm.findFirst(User.class);

        //System.out.println(fromDb2.getUsername());

        // Order first = orderEm.findFirst(Order.class);
        // System.out.println(first.getOrderId());

        // Iterable<User> users = userEm.find(User.class);
        // users.forEach(u -> System.out.println(u.getUsername()));

        fromDb.setUsername("edited");
        userEm.persist(fromDb);
    }
}