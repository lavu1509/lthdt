/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsp.model;

import java.sql.Date;

/**
 *
 * @author Fox0fNight
 */
public class Product {
    private int id;
    private String proname;
    private int quantity;

    public Product() {
    }

    public Product(int id, String proname, int quantity) {
        this.id = id;
        this.proname = proname;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

  

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
