package com.moggi.quizmini.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteJDBC {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:quizmini.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "create table folder(" +
                    "    fo_pkid     INT PRIMARY KEY NOT NULL," +
                    "    fo_name     TEXT            NOT NULL," +
                    "    create_time TEXT            NOT NULL," +
                    "    modify_time TEXT            NOT NULL" +
                    ")";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}