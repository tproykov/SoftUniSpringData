package com.jmc;

import java.sql.*;
import java.util.Scanner;

public class GetMinionNames {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        String villainId = scanner.nextLine();

        Connection connection = DatabaseUtil.getConnection("minions_db");

        boolean villainExists = printVillain(connection, villainId);

        if (villainExists) {
            printMinions(connection, villainId);

        }
    }

    private static boolean printVillain(Connection connection, String villainId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("""
                SELECT v.name
                FROM villains v
                WHERE v.id = ?;""");

        statement.setString(1, villainId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println(name);
            return true;
        } else {
            System.out.println("Villain with this ID does not exist.");
            return false;
        }
    }

    private static void printMinions(Connection connection, String villainId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("""
                SELECT DISTINCT m.name, m.age
                FROM minions_villains mv
                JOIN minions m ON mv.minion_id = m.id
                WHERE mv.villain_id = ?;""");

        statement.setString(1, villainId);

        int order = 1;
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String minionName = resultSet.getString(1);
            int age = resultSet.getInt(2);

            System.out.printf("%d. %s %d\n", order++, minionName, age);
        }
    }
}