/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MAICON
 */
public class ProductTableModel extends AbstractTableModel{
    private List<Product> products;
    
    public ProductTableModel(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return this.products.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = this.products.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return product.getId();
            case 1:
                return product.getName();
            case 2:
                return product.getDescription();
            case 3:
                return product.getPriceFormated();
            case 4:
                return product.getNamesCategories();                
            default:
                return null;
        }
    }   

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "NAME";
            case 2:
                return "DESCRIPTION";
            case 3:
                return "PRICE";
            case 4:
                return "CATEGORIES";                
            default:
                return "";
        }
    }
    
    public Product getProduct(int index){
        return this.products.get(index);
    }
    
    public void removeProduct(int index){
        this.products.remove(index);
        
        fireTableDataChanged();
    }
    
    public void updateTable(){
        fireTableDataChanged();
    }
    
    public void setList(List<Product> newList){
        this.products.clear();
        
        this.products.addAll(newList);
        fireTableDataChanged();        
    }    
}
