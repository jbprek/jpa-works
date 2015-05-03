package org.bagab.ee7.patterns.dao;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by x on 5/2/15.
 */

@Stateless
@LocalBean
public class DAOBoundary implements DAO<Long, TestEntity> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public TestEntity create(TestEntity testEntity) {
        em.persist(testEntity);
        return testEntity;
    }

    @Override
    public TestEntity read(Long id) {
        return em.find(TestEntity.class, id);
    }

    @Override
    public TestEntity update(TestEntity testEntity) {
        em.merge(testEntity);
        return testEntity;
    }

    @Override
    public void delete(TestEntity testEntity) {
        Object ref = this.em.getReference(testEntity.getClass(), testEntity.getId());
        this.em.remove(ref);
    }

    @Override
    public Collection<TestEntity> findByNamedQuery(String queryName) {
        return null;
    }

    @Override
    public Collection<TestEntity> findByNamedQuery(String queryName, int resultLimit) {
        return null;
    }

    @Override
    public List<TestEntity> findByNamedQuery(String namedQueryName, Map<String, Object> parameters) {
        return null;
    }

    @Override
    public List<TestEntity> findByNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit) {
        return null;
    }
}
