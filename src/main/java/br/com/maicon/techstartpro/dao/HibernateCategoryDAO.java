/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.dao;

import br.com.maicon.techstartpro.model.Category;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author MAICON
 */
public class HibernateCategoryDAO extends HibernateGenericDAO<Category, Long>{

    public HibernateCategoryDAO() {
        super();
    }    
    
    public Category findByName(String name) throws Exception {
        getConnection();
        
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Category> query = cb.createQuery(Category.class);
        Root<Category> c = query.from(Category.class);
        query.where(cb.equal(c.get("name"), name));
        
        Category category = manager.createQuery(query).getResultList().stream().findFirst().orElse(null);;
        manager.close();

        return category;
    }    
}
