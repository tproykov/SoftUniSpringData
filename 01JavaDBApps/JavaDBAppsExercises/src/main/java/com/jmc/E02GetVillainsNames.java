package com.jmc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class E02GetVillainsNames {

    public static void main(String[] args) throws SQLException {

        Connection connection = DatabaseUtil.getConnection("minions_db");

        PreparedStatement preparedStatement = connection
                .prepareStatement("""
                        SELECT v.id, v.name, COUNT(*) count_minions
                        FROM villains v
                        INNER JOIN minions_villains mv ON v.id = mv.villain_id
                        GROUP BY v.id
                        HAVING count_minions > 15
                        ORDER BY count_minions DESC;""");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int countMinions = resultSet.getInt("count_minions");

            System.out.printf("%s - %d\n", name, countMinions);
        }
    }
}