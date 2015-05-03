package org.bagab.ee7.patterns.dao;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by x on 5/2/15.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)

public class GenericDao {
    @PersistenceContext
    EntityManager em;

    public <T> T create(T t) {
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }

    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> type,Object id) {
        return (T) this.em.find(type, id);
    }

    public void delete(Class type,Object id) {
        Object ref = this.em.getReference(type, id);
        this.em.remove(ref);
    }

    public <T> T update(T t) {
        return (T)this.em.merge(t);
    }

    public List findWithNamedQuery(String namedQueryName){
        return this.em.createNamedQuery(namedQueryName).getResultList();
    }

    public List findWithNamedQuery(String namedQueryName, Map<String,Object> parameters){
        return findWithNamedQuery(namedQueryName, parameters, 0);
    }

    public List findWithNamedQuery(String queryName, int resultLimit) {
        return this.em.createNamedQuery(queryName).
                setMaxResults(resultLimit).
                getResultList();
    }

    public <T> List<T> findByNativeQuery(String sql, Class<T> type) {
        return this.em.createNativeQuery(sql, type).getResultList();
    }

    public List findWithNamedQuery(String namedQueryName, Map<String,Object> parameters,int resultLimit){
        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        Query query = this.em.createNamedQuery(namedQueryName);
        if(resultLimit > 0)
            query.setMaxResults(resultLimit);
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }
}
