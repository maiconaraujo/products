/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MAICON
 */
public class CategoryTableModel extends AbstractTableModel{
    private List<Category> categories;
    
    public CategoryTableModel(List<Category> categories) {
        this.categories = categories;
    }
    
    public CategoryTableModel() {
        this.categories = new ArrayList<>();
    }
        
    @Override
    public int getRowCount() {
        return this.categories.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category category = this.categories.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return category.getName();           
            default:
                return null;
        }
    }   

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Categories Added";    
            default:
                return "";
        }
    }
    
    public Category getCategory(int index){
        return this.categories.get(index);
    }
    
    public void removeCategory(int index){
        this.categories.remove(index);
        
        fireTableDataChanged();
    }
    
    public void updateTable(){
        fireTableDataChanged();
    }
    
    public void add(Category category){
        this.categories.add(category);

        fireTableDataChanged();        
    }    
    
    public boolean contains(Category category){
        return this.categories.contains(category);
    }
    
    public List<Category> getListCategories(){
        return categories;
    }
    
    public void setList(List<Category> newList){
        this.categories.clear();
        
        this.categories.addAll(newList);
        fireTableDataChanged();        
    }     
}
