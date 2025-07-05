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

        String villainName = getVillainName(connection, villainId);
        if (villainName == null) {
            System.out.println("No such villain was found");
        } else {
            connection.setAutoCommit(false);

            try {
                int releasedMinionsCount = deleteConnectedEntities(connection, villainId);
                deleteVillain(connection, villainId);
                connection.commit();

                System.out.printf("%s was deleted\n", villainName);
                System.out.printf("%d minions released\n", releasedMinionsCount);
            } catch (SQLException e) {
                connection.rollback();
            }
        }
    }

    private static String getVillainName(Connection connection, int villainId) throws SQLException {
        PreparedStatement selectStatement = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
        selectStatement.setInt(1, villainId);
        ResultSet resultSet = selectStatement.executeQuery();
        if (!resultSet.next()) {
            return null;
        }
        return resultSet.getString(1);
    }

    private static int deleteConnectedEntities(Connection connection, int villainId) throws SQLException {
        PreparedStatement deleteStatement = connection.prepareStatement("""
                DELETE FROM minions_villains WHERE villain_id = ?;""");
        deleteStatement.setInt(1, villainId);
        return deleteStatement.executeUpdate();
    }

    private static void deleteVillain(Connection connection, int villainId) throws SQLException {
        PreparedStatement deleteStatement = connection.prepareStatement("""
                DELETE FROM villains
                WHERE id = ?;""");
        deleteStatement.setInt(1, villainId);
        deleteStatement.executeUpdate();
    }
}