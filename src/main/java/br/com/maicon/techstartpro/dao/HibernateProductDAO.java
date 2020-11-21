/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.dao;

import br.com.maicon.techstartpro.model.Product;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author MAICON
 */
public class HibernateProductDAO extends HibernateGenericDAO<Product, Long> {

    public HibernateProductDAO() {
        super();
    }
    public List<Product> findByFilter(Product product) throws Exception {
        getConnection();

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery =  builder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
 
        ProductPredicateFilter predicateFilter = new ProductPredicateFilter(product);
        Predicate predicate = predicateFilter.toPredicate(root, criteriaQuery, builder);
        criteriaQuery.where(predicate);
        List<Product> products = manager.createQuery(criteriaQuery).getResultList();

        return products;
    }

}
