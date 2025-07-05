package com.jmc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class e06RemoveVillain {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        Connection connection = DatabaseUtil.getConnection("minions_db");

        String villainName = foundVillain(connection, villainId);
        if (villainName == null) {
            System.out.println("No such villain was found");
        }
        else {



        }






    }

    private static String foundVillain(Connection connection, int villainId) throws SQLException {
        PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM villains WHERE id = ?");
        selectStatement.setInt(1, villainId);
        ResultSet resultSet = selectStatement.executeQuery();
        if (!resultSet.next()) {
            return null;
        }
        return resultSet.getString(1);
    }
}