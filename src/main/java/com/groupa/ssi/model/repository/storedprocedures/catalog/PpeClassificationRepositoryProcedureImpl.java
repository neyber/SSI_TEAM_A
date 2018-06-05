package com.groupa.ssi.model.repository.storedprocedures.catalog;

import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.PpeClassificationProcedures;
import com.groupa.ssi.model.repository.storedprocedures.util.SaCategoryProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/*
Created on 3/6/18
@author: HENRYBC
*/
public class PpeClassificationRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<PpeClassification, PpeClassificationProcedures>
        implements PpeClassificationRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public PpeClassificationProcedures getProcedureNames() {
        return new PpeClassificationProcedures();
    }

    @Override
    public PpeClassification execProcedureCreate(PpeClassification entity) {
        log.debug("Executing execProcedureCreate procedure.... " + PpeClassificationProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(PpeClassificationProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);

        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("description", entity.getDescription());

        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public PpeClassification execProcedureUpdate(PpeClassification entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + PpeClassificationProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(PpeClassificationProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);


        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("description", entity.getDescription());

        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }

}
