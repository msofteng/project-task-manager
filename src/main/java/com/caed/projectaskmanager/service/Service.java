package com.caed.projectaskmanager.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Service<T> {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Class<T> clazz;

    public Service(Class<T> clazz) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.clazz = clazz;
    }

    public void create(T value) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(value);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    public T findById(Long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        // Construir a consulta dinamicamente
        String jpql = "SELECT c FROM " + clazz.getSimpleName() + " c";
        return entityManager.createQuery(jpql, clazz).getResultList();
    }

    public void update(T value) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(value); // Atualiza o cliente no banco
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    public void delete(Long id) {
        try {
            entityManager.getTransaction().begin();
            T value = entityManager.find(clazz, id);
            if (value != null) {
                entityManager.remove(value);
            }
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
