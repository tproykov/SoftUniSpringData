package com.jmc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMinion {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        String[] minionData = scanner.nextLine().split("\\s+");
        String[] villainData = scanner.nextLine().split("\\s+");
        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String minionTown = minionData[3];
        String villainName = villainData[1];

        Connection connection = DatabaseUtil.getConnection("minions_db");

        int townId = ensureTown(connection, minionTown);
        System.out.println(townId);
    }

    private static int ensureTown(Connection connection, String name) throws SQLException {
        PreparedStatement selectStatement = connection.prepareStatement("""
                SELECT t.id
                FROM towns t
                WHERE t.name = ?;""");

        selectStatement.setString(1, name);
        ResultSet resultSet = selectStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }

        PreparedStatement insertStatement = connection.prepareStatement("""
                INSERT INTO towns (name)
                VALUE (?);""", PreparedStatement.RETURN_GENERATED_KEYS);

        insertStatement.setString(1, name);
        insertStatement.executeUpdate();

        ResultSet generatedKeys = insertStatement.getGeneratedKeys();
        if (!generatedKeys.next()) throw new IllegalStateException("Could not access generated key for town"); {

        }
        System.out.printf("%s was added to the database.\n",name);
        return generatedKeys.getInt(1);
    }

    private static int ensureVillain(Connection connection, String name) throws SQLException {
        PreparedStatement selectStatement = connection.prepareStatement("""
                SELECT v.id
                FROM villains v
                WHERE v.name = ?;""");
        selectStatement.setString(1, name);
        ResultSet resultSet = selectStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }

        PreparedStatement insertStatement = connection.prepareStatement("""
                INSERT INTO villains (name)
                VALUE (?);""", PreparedStatement.RETURN_GENERATED_KEYS);


    }
}