/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MAICON
 */
public class ConnectionFactory {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("TechStartPro-PU");    
 
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }    
    
    public static boolean verifyConnection(){
        EntityManager manager = factory.createEntityManager();
        if(manager.isOpen()){
            manager.close();
            return true;
        }else{
            return false;
        }
    }    
}
