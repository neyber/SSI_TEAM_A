package com.groupa.ssi.model.repository.storedprocedures.common;

import com.groupa.ssi.model.repository.storedprocedures.util.GenericProcedureNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Miguel Rojas
 */
public abstract class GenericRepositoryProcedureImpl<T, K extends GenericProcedureNames> implements GenericRepositoryProcedure<T, K> {
    private static Logger log = LoggerFactory.getLogger(GenericRepositoryProcedureImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<T> execProcedureFindAll(K procedureNames) {
        log.debug("Executing execProcedureFindAll procedure.... " + procedureNames.allProcedureName());

        StoredProcedureQuery procedureQuery = em.createNamedStoredProcedureQuery(procedureNames.allProcedureName());
        return  procedureQuery.getResultList();
    }

    @Override
    public T execProcedureFindById(Integer id, K procedureNames) {
        log.debug("Executing execProcedureFindById procedure.... " + procedureNames.readProcedureName());
        T entity = null;

        // Dynamic stored procedure definition by index parameter.
        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(procedureNames.readProcedureName(), getGenericTypeClass());
        procedureQuery.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
        procedureQuery.setParameter(1, id);

        // Stored procedure call
        entity = (T) procedureQuery.getSingleResult();
        return entity;
    }

    @Override
    public void execProcedureDeleteById(Integer id, K procedureNames) {
        log.debug("Executing execProcedureDeleteById procedure.... " + procedureNames.deleteProcedureName());

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(procedureNames.deleteProcedureName());
        procedureQuery.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
        procedureQuery.setParameter(1, id);

        // Stored procedure call for delete
        procedureQuery.executeUpdate();
    }

    private Class<T> getGenericTypeClass() {
        try {
            String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
            Class<?> clazz = Class.forName(className);
            return (Class<T>) clazz;
        } catch (Exception e) {
            throw new IllegalStateException("Repository Class is not parametrized with generic type!!! Please use extends <>");
        }
    }

}
