/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsp.controller;

import java.util.List;
import qlsp.model.Product;
import qlsp.model.ProductDAO;

/**
 *
 * @author Fox0fNight
 */
public class ProductController {
   
    private ProductDAO productdao;

    public ProductController() {
        productdao = new ProductDAO();
    }
    
    public List<Product> getAllProducts(){
         return productdao.getAllProducts();
    }
    public void addProduct(Product product){
        productdao.addProduct(product);
    }
}
