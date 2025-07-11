package com.jmc;

import com.jmc.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure();

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session currentSession = sessionFactory.openSession();

        currentSession.getTransaction().begin();

        // CREATE STUDENT
        // Student student = new Student();
        // student.setName("John Doe");
        // currentSession.persist(student);

        // FIND SPECIFIC STUDENT BY ID
        // Student found = currentSession.find(Student.class, 1);
        // System.out.println(found.getName());



        currentSession.getTransaction().commit();
        currentSession.close();

    }
}