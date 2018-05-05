package com.groupa.ssi.services.common;

import com.groupa.ssi.exception.DeleteEntityNotFoundException;
import com.groupa.ssi.exception.DomainEntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic service to make CRUD operations
 * @author Miguel Rojas
 */
@Service
public abstract class GenericService<T> {

    public List<T> findAll() {
        List<T> results = new ArrayList<>();
        getRepository().findAll().forEach(results::add);
        return results;
    }

    public T findById(Integer id) {
        return getRepository().findById(id).orElseThrow(() -> new DomainEntityNotFoundException(getGenericTypeClass()));
    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public void deleteById(Integer id) {
        try {
            getRepository().deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DeleteEntityNotFoundException(getGenericTypeClass());
        }
    }

    protected abstract JpaRepository<T, Integer> getRepository();

    private Class<T> getGenericTypeClass() {
        try {
            String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
            Class<?> clazz = Class.forName(className);
            return (Class<T>) clazz;
        } catch (Exception e) {
            throw new IllegalStateException("Class is not parametrized with generic type!!! Please use extends <>");
        }
    }
}
