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