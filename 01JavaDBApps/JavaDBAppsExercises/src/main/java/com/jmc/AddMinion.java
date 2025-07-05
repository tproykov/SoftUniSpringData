package com.jmc;

import java.sql.Connection;
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













    }

    private static int ensureTown(Connection connection, String name) {


        return 0;
    }








}
