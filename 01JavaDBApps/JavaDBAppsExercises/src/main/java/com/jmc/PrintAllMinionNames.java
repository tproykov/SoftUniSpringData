package com.jmc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintAllMinionNames {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Connection connection = DatabaseUtil.getConnection("minions_db");

        PreparedStatement preparedStatement = connection.prepareStatement("""
                SELECT m.name FROM minions m;""");

        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> minionNames = new ArrayList<>();

        while (resultSet.next()) {
            minionNames.add(resultSet.getString(1));
        }

        for (String minionName : minionNames) {
            System.out.println(minionName);
        }













    }
}
