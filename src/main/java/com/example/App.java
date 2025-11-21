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
        String getAllRecordsQuery = "select * from student";
        String insertQuery = "insert into student values (5, 'John', 48)";
        String updateQuery = "update student set sname = 'Max' where sid = 1";
        String deleteQuery = "delete student where sid = 1";
        
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        System.out.println("Connection Established ");

        // Fetching all records
        ResultSet rs = st.executeQuery(getAllRecordsQuery);
        while (rs.next()) {
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.print(rs.getString(3));
            System.out.println();

        }

        // Inserting data into a table
        boolean insertStatus = st.execute(insertQuery);
        System.out.println("Inserted document successfully" + insertStatus);
        
        // Update data into a table
        boolean updateStatus = st.execute(updateQuery);
        System.out.println("Updated document successfully" + updateStatus);
        
        // Delete a data in a table
        boolean deleteStatus = st.execute(deleteQuery);
        System.out.println("Updated document successfully" + deleteStatus);

        con.close();
        System.out.println("Connection closed");

    }
}
