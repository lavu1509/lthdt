/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnhStore.model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fox0fNight
 */
public class JDBCConnection {

 
    public static Connection getJDBCConnection() {

        Connection cons = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/qlsp", "root", "qqq111");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cons;
    }  
}
