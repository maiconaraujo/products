/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MAICON
 * @param <T>
 * @param <ID>
 */
public interface GenericDAO<T, ID extends Serializable> {
    
    public abstract List<T> findAll() throws Exception;            
    public abstract T findByID(ID id) throws Exception;
    public abstract void save(T obj) throws Exception;
    public abstract void update(T obj) throws Exception;
    public abstract void remove(ID id) throws Exception;
}
