package ca.jrvs.apps.twitter.dao;

public interface CrdRepository<T,ID> {
    T save(T entity);
    T findById(ID id);
    T deleById(ID id);
}
