/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnhStore.view;

import AnhStore.model.Product;
import AnhStore.model.ProductDAO;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Fox0fNight
 */
public class ProductController {

    private ProductDAO dao;

    public ProductController() {
        dao = new ProductDAO();
    }

    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    public void addProduct(Product product) {
        dao.addProduct(product);
    }
    public void addProductWithImage(Product product) {
        dao.addProductWithImage(product);
    }
    public void delProduct(int id){
        dao.deleteProduct(id);
    }
    
    public Product getProductById(int id){
        return dao.getProductById(id);
    }
    public Product getProductByIdWithImage(int id){
        return dao.getProductByIdWithImage(id);
    }
    public void editProduct(Product product){
        dao.updateProduct(product);
    }
}
