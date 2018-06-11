package com.groupa.ssi.model.repository.storedprocedures.common;

import com.groupa.ssi.common.utils.Constants;
import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.repository.storedprocedures.util.GenericProcedureNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

/**
 * @author Miguel Rojas
 */
public abstract class GenericRepositoryProcedureImpl<T, K extends GenericProcedureNames> implements GenericRepositoryProcedure<T, K> {
    private static Logger log = LoggerFactory.getLogger(GenericRepositoryProcedureImpl.class);

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<T> execProcedureFindAll() {
        K procedureNames = getProcedureNames();
        log.debug("Executing execProcedureFindAll procedure.... " + procedureNames.allProcedureName());

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(procedureNames.allProcedureName(), getGenericTypeClass());
        return  procedureQuery.getResultList();
    }

    @Override
    public T execProcedureFindById(Integer id) {
        K procedureNames = getProcedureNames();
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
    public void execProcedureDeleteById(Integer id) {
        K procedureNames = getProcedureNames();
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

    protected void addCreateCommonParameters(StoredProcedureQuery procedureQuery) {
        procedureQuery.registerStoredProcedureParameter("newId", Integer.class, ParameterMode.OUT);
        procedureQuery.registerStoredProcedureParameter("createdBy", Integer.class, ParameterMode.IN);
        procedureQuery.setParameter("createdBy", Constants.USER_ID);
    }

    protected Integer getNewIdAsOutPutParameter(StoredProcedureQuery procedureQuery) {
        return (Integer) procedureQuery.getOutputParameterValue("newId");
    }

    protected void addUpdateCommonParameters(StoredProcedureQuery procedureQuery, ModelBase entity) {
        entity.setUpdatedBy(Constants.USER_ID);  //this because entity is managed by jpa and not is detached

        procedureQuery.registerStoredProcedureParameter("updatedBy", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("updatedOn", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("version", Long.class, ParameterMode.IN);

        procedureQuery.setParameter("updatedBy", entity.getUpdatedBy());
        procedureQuery.setParameter("updatedOn", new Date());
        procedureQuery.setParameter("version", entity.getVersion());
    }

}
