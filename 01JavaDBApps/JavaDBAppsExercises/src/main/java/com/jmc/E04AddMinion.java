package com.jmc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class E04AddMinion {

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
        int villainId = ensureVillain(connection, villainName);
        int minionId = createMinion(connection, minionName, minionAge, townId);
        connectMinionAndVillain(connection, minionId, villainId);

        System.out.printf("Successfully added %s to be minion of %s.\n", minionName, villainName);
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
        if (!generatedKeys.next()) throw new IllegalStateException("Could not access generated key for town.");
        System.out.printf("Town %s was added to the database.\n",name);
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
                INSERT INTO villains (name, evilness_factor)
                VALUE (?, 'evil');""", PreparedStatement.RETURN_GENERATED_KEYS);

        insertStatement.setString(1, name);
        insertStatement.executeUpdate();

        ResultSet generatedKeys = insertStatement.getGeneratedKeys();
        if (!generatedKeys.next()) throw new IllegalStateException("Could not access generated key for villain.");
        System.out.printf("Villain %s was added to the database.\n",name);
        return generatedKeys.getInt(1);
    }

    private static int createMinion(Connection connection, String name, int age, int townId) throws SQLException {
        PreparedStatement insertStatement = connection.prepareStatement("""
                INSERT INTO minions (name, age, town_id)
                VALUES (?, ?, ?);""", PreparedStatement.RETURN_GENERATED_KEYS);
        insertStatement.setString(1, name);
        insertStatement.setInt(2, age);
        insertStatement.setInt(3, townId);

        insertStatement.executeUpdate();
        ResultSet generatedKeys = insertStatement.getGeneratedKeys();

        if (!generatedKeys.next()) throw new IllegalStateException("Could not access generated key for minion.");
        return generatedKeys.getInt(1);
    }

    private static void connectMinionAndVillain(Connection connection, int minionId, int villainId) throws SQLException {
        PreparedStatement connectStatement = connection.prepareStatement("""
                INSERT INTO minions_villains (minion_id, villain_id)
                VALUES (?, ?);""");
        connectStatement.setInt(1, minionId);
        connectStatement.setInt(2, villainId);

        connectStatement.executeUpdate();
    }
}