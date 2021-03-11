/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlsp.model.Product;

/**
 *
 * @author Fox0fNight
 */
public class ProductDAO {

    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM product";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product pro = new Product();

                pro.setId(rs.getInt("ID"));
                pro.setProname(rs.getString("PRO_NAME"));
                pro.setQuantity(rs.getInt("QUANTITY"));

                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
  
    public void addProduct(Product product) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO product(PRO_NAME,QUANTITY) VALUES(?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, product.getProname());
            pst.setInt(2, product.getQuantity());

            pst.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateProduct(Product product) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE product SET PRO_NAME=?,QUANTITY=? WHERE ID=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, product.getProname());
            pst.setInt(2, product.getQuantity());
            pst.setInt(3, product.getId());

            pst.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteProduct(int id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM product WHERE ID = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
