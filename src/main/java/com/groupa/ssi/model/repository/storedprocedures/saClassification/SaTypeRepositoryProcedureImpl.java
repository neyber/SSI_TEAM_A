package com.groupa.ssi.model.repository.storedprocedures.saClassification;

import com.groupa.ssi.model.domain.saClassification.SaType;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.SaTypeProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/*
Created on 3/6/18
@author: HENRYBC
*/
public class SaTypeRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<SaType, SaTypeProcedures>
        implements SaTypeRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public SaTypeProcedures getProcedureNames() {
        return new SaTypeProcedures();
    }

    @Override
    public SaType execProcedureCreate(SaType entity) {
        log.debug("Executing execProcedureCreate procedure.... " + SaTypeProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(SaTypeProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("type", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);

        procedureQuery.setParameter("type", entity.getType());
        procedureQuery.setParameter("description", entity.getDescription());

        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);

    }

    @Override
    public SaType execProcedureUpdate(SaType entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + SaTypeProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(SaTypeProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("type", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("type", entity.getType());
        procedureQuery.setParameter("description", entity.getDescription());

        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }
}
