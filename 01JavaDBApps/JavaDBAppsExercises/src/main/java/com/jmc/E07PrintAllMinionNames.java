package com.jmc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class E07PrintAllMinionNames {

    public static void main(String[] args) throws SQLException {

        Connection connection = DatabaseUtil.getConnection("minions_db");

        // getMinionsInMemory(connection);

        PreparedStatement preparedStatement = connection.prepareStatement("""
                SELECT m.name FROM minions m;""", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;
        while (resultSet.next()) {
            count++;
        }

        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                resultSet.absolute(i/2 + 1);
            }
            else {
                resultSet.absolute(count - (i - 1) / 2);
            }

            String minionName = resultSet.getString(1);
            System.out.println(minionName);
        }
    }

    private static void getMinionsInMemory(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("""
                SELECT m.name FROM minions m;""");

        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> minionNames = new ArrayList<>();

        while (resultSet.next()) {
            minionNames.add(resultSet.getString(1));
        }

        List<String> orderedMinionNames = new ArrayList<>();
        for (int i = 0; i < minionNames.size(); i++) {
            if (i % 2 == 0) {
                orderedMinionNames.add(minionNames.get(i / 2));
            }
            else {
                orderedMinionNames.add(minionNames.get(minionNames.size() - (i + 1) / 2));
            }
        }

        for (String minionName : orderedMinionNames) {
            System.out.println(minionName);
        }
    }
}