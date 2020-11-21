/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.dao;

import br.com.maicon.techstartpro.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author MAICON
 */
public class ProductPredicateFilter {

    private Product product;
    List<Predicate> predicates = new ArrayList<>();

    public ProductPredicateFilter(Product product) {
        this.product = product;
    }

    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (!product.getName().isEmpty()) {
            predicates.add(builder.like(root.get("name"), "%" + product.getName() + "%"));
        }
        
        if (!product.getDescription().isEmpty()) {
            predicates.add(builder.like(root.get("description"), "%" + product.getDescription() + "%"));
        }  
                
        if (product.getPrice() != null && product.getPrice().doubleValue() > 0) {
            predicates.add(builder.equal(root.get("price"), product.getPrice()));
        }               

        if (product.getCategories()!= null  && !product.getCategories().isEmpty()) {            
            predicates.add(builder.equal(root.join("categories").get("id"), product.getCategories().get(0).getId()));            
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }

}
