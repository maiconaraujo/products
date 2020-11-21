/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MAICON
 * @param <T>
 * @param <ID>
 */
public abstract class HibernateGenericDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

    protected EntityManager manager;

    private Class<T> classEntity;

    @SuppressWarnings("unchecked")
    public HibernateGenericDAO() {
        this.classEntity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        manager = ConnectionFactory.getEntityManager();
    }

    @Override
    public List<T> findAll() throws Exception {
        getConnection();
        return manager.createQuery("from " + classEntity.getName()).getResultList();
    }

    @Override
    public T findByID(ID id) throws Exception {
        getConnection();
        T obj = manager.find(classEntity, id);
        manager.close();

        return obj;
    }

    @Override
    public void save(T obj) throws Exception {
        try {
            getConnection();
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            manager.close();
        }
    }

    @Override
    public void update(T obj) throws Exception {
        try {
            getConnection();
            manager.getTransaction().begin();
            manager.merge(obj);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            manager.getTransaction().rollback();
            throw new Exception(ex);
        } finally {
            manager.close();
        }

    }

    @Override
    public void remove(ID id) throws Exception {
        try {
            getConnection();
            T obj = manager.find(classEntity, id);
            manager.getTransaction().begin();
            manager.remove(obj);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            manager.getTransaction().rollback();
            throw new Exception(ex);
        } finally {
            manager.close();
        }
    }

    protected void getConnection() {
        if (!manager.isOpen()) {
            manager = ConnectionFactory.getEntityManager();
        }
    }

}
