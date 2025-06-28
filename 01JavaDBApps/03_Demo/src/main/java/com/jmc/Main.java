package com.jmc;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username default (root): ");

        String user = sc.nextLine();
        user = user.isEmpty() ? "root" : user;

        System.out.println();

        System.out.print("Enter password default (empty):");

        String password = sc.nextLine().trim();

        System.out.println();

        Properties properties = new Properties();

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soft_uni", properties);

        PreparedStatement stmt =
                connection.prepareStatement("" +
                        "SELECT * FROM employees WHERE salary > ?");

        String salary = sc.nextLine();
        stmt.setDouble(1, Double.parseDouble(salary));
        ResultSet resultSet = stmt.executeQuery();

        while(resultSet.next()){
            System.out.println(resultSet.getString("first_name") + " " +
                    resultSet.getString("last_name") + " - " + resultSet.getString("job_title"));
        }
        connection.close();
    }
}