package com.montrell;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:mysql://localhost:3306/testreimbursmentsystem";
        String username ="root";
        String pass = "Password12!";

        Connection con;
        Statement st;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,pass);
            st = con.createStatement();
            String query = "select * from users";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString(2));
            }
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
