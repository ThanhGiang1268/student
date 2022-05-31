/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_contact_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class myConnection {

    public static Connection getConnection() throws ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javacontactapp", "root", "");
            return con;
        } 
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
