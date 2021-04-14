/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnhStore.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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

                pro.setId(rs.getInt("id"));
                pro.setFullname(rs.getString("proname"));
                pro.setSoluong(rs.getInt("soluong"));
                pro.setGia(rs.getInt("gia"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
      public Product getProductById(int idpro) {

        Connection conn = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM product WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idpro);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product pro = new Product();

                pro.setId(rs.getInt("id"));
                pro.setFullname(rs.getString("proname"));
                pro.setSoluong(rs.getInt("soluong"));
                pro.setGia(rs.getInt("gia"));
                
                return pro;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
       public Product getProductByIdWithImage(int idpro)  {

        Connection conn = JDBCConnection.getJDBCConnection();
        Product pro = new Product();

        String sql = "SELECT * FROM product WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idpro);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                pro.setId(rs.getInt("id"));
                pro.setFullname(rs.getString("proname"));
                pro.setSoluong(rs.getInt("soluong"));
                pro.setGia(rs.getInt("gia"));
                //chua co
                Blob blob = rs.getBlob("image");
                InputStream in = blob.getBinaryStream();
                pro.setImageOut(ImageIO.read(in));
                
                return pro;
            }
            conn.close();
        } catch (SQLException|IOException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
      public void addProduct(Product product) {
        Connection conn = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO product (proname,soluong,gia) VALUES (?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, product.getFullname());
            pst.setInt(2, product.getSoluong());
            pst.setInt(3, product.getGia());

            pst.executeUpdate();
            

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public void addProductWithImage(Product product) {
        Connection conn = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO product (proname,soluong,gia,image) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, product.getFullname());
            pst.setInt(2, product.getSoluong());
            pst.setInt(3, product.getGia());
            pst.setBlob(4, product.getImageIn());
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateProduct(Product product) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE product SET proname=?,soluong=?,gia=? WHERE id=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, product.getFullname());
            pst.setInt(2, product.getSoluong());
            pst.setInt(3, product.getGia());
            pst.setInt(4, product.getId());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteProduct(int id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM product WHERE id = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
