/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnhStore.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyPC
 */
public class Product {

    private int id;
    private String fullname;
    private int soluong;
    private int gia;
    private FileInputStream imageIn;
    private BufferedImage imageOut;
    

    public Product() {
    }
    
    
    
    public Product(int id, String fullname, int soluong, int gia) {
        this.id = id;
        this.fullname = fullname;
        this.soluong = soluong;
        this.gia = gia;
    }

    public Product(String fullname, int soluong, int gia,String imagepath) {
        this.fullname = fullname;
        this.soluong = soluong;
        this.gia = gia;
        try {
            //Đọc ảnh vào bộ nhớ
            this.imageIn = new FileInputStream(new File(imagepath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public FileInputStream getImageIn() {
        return imageIn;
    }

    public void setImageIn(FileInputStream imageIn) {
        this.imageIn = imageIn;
    }

    public BufferedImage getImageOut() {
        return imageOut;
    }

    public void setImageOut(BufferedImage imageOut) {
        this.imageOut = imageOut;
    }

   
    
   
    

}
