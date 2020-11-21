/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.controller;

import br.com.maicon.techstartpro.dao.HibernateProductDAO;
import br.com.maicon.techstartpro.model.Product;
import java.util.List;

/**
 *
 * @author MAICON
 */
public class ProductController {
    private HibernateProductDAO productDAO;

    public ProductController() {
        productDAO = new HibernateProductDAO();
    }  
    
    public List<Product> listProducts() throws Exception{
        return productDAO.findAll();
    }
    
    public void saveProduct(Product product) throws Exception{
        if(product.getId() != null && product.getId() > 0){
            productDAO.update(product);
        }else{                        
            productDAO.save(product);
        }
    } 
          
    public void removeProduct(Long id) throws Exception{
        productDAO.remove(id);
    }
    
    public List<Product> searchProductByFilter(Product productSearch) throws Exception {
        return productDAO.findByFilter(productSearch);
    }    
}
