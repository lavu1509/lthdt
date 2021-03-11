/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Fox0fNight
 */
public class JDBConnection {
    
    public static void main(String[] args)  {
        // TODO code application logic here
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sakila",
                    "root", "qqq111")) {
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery("select * from actor");
                while(rs.next())
                    System.out.println(rs.getInt("actor_id")+"  "+rs.getString("first_name")+"  "+rs.getString("last_name"));
            }  
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
