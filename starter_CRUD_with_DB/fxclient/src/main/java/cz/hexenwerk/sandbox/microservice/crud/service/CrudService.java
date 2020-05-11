package cz.hexenwerk.sandbox.microservice.crud.service;

import java.util.List;

public interface CrudService<T extends Object> {

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(Long id);

    void deleteInBatch(List<T> entities);

    T findById(Long id);

    List<T> findAll();
}
