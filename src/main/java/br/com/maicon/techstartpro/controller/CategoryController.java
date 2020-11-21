/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.controller;

import br.com.maicon.techstartpro.dao.HibernateCategoryDAO;
import br.com.maicon.techstartpro.model.Category;
import br.com.maicon.techstartpro.utils.ReadCSV;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maicon
 */
public class CategoryController {
    private HibernateCategoryDAO categoryDAO;

    public CategoryController() {
        categoryDAO = new HibernateCategoryDAO();
    }    
    
    public List<Category> listCategories() throws Exception{
        return categoryDAO.findAll();
    }    
    
    public List<Category> importCategories(File file) throws Exception{        
            List<Category> categories = ReadCSV.readCategoriesCSV(file);
  
            List<Category> categoriesImported = new ArrayList<>();
            categories.forEach(c -> {
                try {
                    if(categoryDAO.findByName(c.getName()) == null){
                        categoryDAO.save(c);
                        categoriesImported.add(c);                        
                    }
                } catch (Exception ex) {}
            });
            
            return categoriesImported;
    }
    
}
