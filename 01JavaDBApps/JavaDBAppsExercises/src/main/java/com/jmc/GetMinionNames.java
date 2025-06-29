package com.jmc;

import java.sql.*;
import java.util.Scanner;

public class GetMinionNames {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        String villainId = scanner.nextLine();

        Connection connection = DatabaseUtil.getConnection("minions_db");

        PreparedStatement statement = connection
                .prepareStatement("""
                        SELECT v.name
                        FROM villains v
                        WHERE v.id = ?;""");

        statement.setString(1, villainId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println(name);
        } else {
            System.out.println("Villain with this ID does not exist.");
        }

    }
}