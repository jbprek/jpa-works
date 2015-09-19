package com.bagab.ee7.patterns.dao;


import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface DAO<K,T> {
    public  T create(T t);
    public  T read(K id);
    public  T update(T t);
    public void delete(T t);
    public Collection<T> findByNamedQuery(String queryName);
    public Collection<T> findByNamedQuery(String queryName,int resultLimit);
    public List<T> findByNamedQuery(String namedQueryName, Map<String,Object> parameters);
    public List<T> findByNamedQuery(String namedQueryName, Map<String,Object> parameters,int resultLimit);
}
