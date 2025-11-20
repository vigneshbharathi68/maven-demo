package com.example;

import java.sql.*;


/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        /*
         * import package
         * load and register
         * create connection
         * create statement
         * execute statement
         * process the results
         * close
         */
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "1234";
        String query = "select * from student";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        System.out.println("Connection Established ");

        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.print(rs.getString(3));
            System.out.println();

        }
        con.close();
        System.out.println("Connection closed");

    }
}
