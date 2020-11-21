/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author MAICON
 */
@Entity
@Table(name="products")
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String description;   
    
    @Column(nullable = false)
    private BigDecimal price;    
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="products_has_categories", joinColumns=
    {@JoinColumn(name="product_id")}, inverseJoinColumns={@JoinColumn(name="category_id")})
    private List<Category> categories;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = categories;
    }    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    public String getPriceFormated(){
        return NumberFormat.getCurrencyInstance().format(price);
    }
    
    public String getNamesCategories(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < categories.size(); i++){
            sb.append(categories.get(i).getName());
            
            if(i < (categories.size()-1)){
                sb.append(", ");
            }
        }
        
        return sb.toString();
    }    
}
