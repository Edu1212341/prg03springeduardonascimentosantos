/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author eduardo
 */
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {
    
    @Autowired
    protected EntityManager entityManager;
    
    @Transactional
    @Override
    public Entity save(Entity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public Entity update(Entity entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Transactional
    @Override
    public void delete(Entity entity) {
        entity = findById(entity.getId());
        entityManager.remove(entity);
    }

    @Transactional
    @Override
    public List<Entity> findAll() {
        return entityManager.createQuery("from " + getTypeClass().getName()).getResultList();
    }

    @Transactional
    @Override
    public Entity findById(Long id) {
        return (Entity) entityManager.find(getTypeClass(), id);
    }
    
    protected Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
}
