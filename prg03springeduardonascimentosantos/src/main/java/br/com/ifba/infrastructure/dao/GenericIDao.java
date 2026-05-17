/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;

/**
 *
 * @author eduardo
 */
public interface GenericIDao<Entity extends PersistenceEntity> {// Basicamente os mé
    Entity save(Entity entity);
    Entity update(Entity entity);
    void delete(Entity entity);
    List<Entity> findAll();
    Entity findById(Long id);
}
