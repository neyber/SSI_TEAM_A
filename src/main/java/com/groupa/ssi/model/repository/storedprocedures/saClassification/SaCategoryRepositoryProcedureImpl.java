package com.groupa.ssi.model.repository.storedprocedures.saClassification;

import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.SaCategoryProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/*
Created on 3/6/18
@author: HENRYBC
*/
public class SaCategoryRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<SaCategory, SaCategoryProcedures>
        implements SaCategoryRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public SaCategoryProcedures getProcedureNames() {
        return new SaCategoryProcedures();
    }

    @Override
    public SaCategory execProcedureCreate(SaCategory entity) {
        log.debug("Executing execProcedureCreate procedure.... " + SaCategoryProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(SaCategoryProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("category", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("reference", String.class, ParameterMode.IN);

        procedureQuery.setParameter("category", entity.getCategory());
        procedureQuery.setParameter("description", entity.getDescription());
        procedureQuery.setParameter("reference", entity.getReference());

        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public SaCategory execProcedureUpdate(SaCategory entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + SaCategoryProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(SaCategoryProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("category", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("reference", String.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("category", entity.getCategory());
        procedureQuery.setParameter("description", entity.getDescription());
        procedureQuery.setParameter("reference", entity.getReference());

        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }
}
