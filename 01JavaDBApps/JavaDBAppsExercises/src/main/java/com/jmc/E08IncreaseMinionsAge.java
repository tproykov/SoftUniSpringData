package com.jmc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E08IncreaseMinionsAge {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        int[] minionIdsToUpdateAge = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Connection connection = DatabaseUtil.getConnection("minions_db");

        updateMinionsAge(connection, minionIdsToUpdateAge);
        printMinions(connection);
    }

    private static void updateMinionsAge(Connection connection, int[] minionIdsUpdateAge) throws SQLException {
        String idParameters = String.join(",", Collections.nCopies(minionIdsUpdateAge.length, "?"));

        PreparedStatement updateStatement = connection.prepareStatement(String.format("""
                UPDATE minions
                SET age = age + 1, name = LOWER(name)
                WHERE id IN (%s);""", idParameters));
        for (int i = 0; i < minionIdsUpdateAge.length; i++) {
            updateStatement.setInt(i + 1, minionIdsUpdateAge[i]);

        }
        updateStatement.executeUpdate();
    }

    private static void printMinions(Connection connection) throws SQLException {
        PreparedStatement printStatement = connection.prepareStatement("""
                SELECT name, age
                FROM `minions`
                """);
        ResultSet resultSet = printStatement.executeQuery();
        while (resultSet.next()) {
            String minionName = resultSet.getString(1);
            int age = resultSet.getInt(2);
            System.out.printf("%s: %d\n", minionName, age);
        }
    }
}