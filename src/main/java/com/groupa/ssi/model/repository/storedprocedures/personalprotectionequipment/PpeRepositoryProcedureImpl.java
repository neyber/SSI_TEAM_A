package com.groupa.ssi.model.repository.storedprocedures.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.PpeProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/*
Created on 3/6/18
@author: HENRYBC
*/
public class PpeRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<Ppe, PpeProcedures>
        implements PpeRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public PpeProcedures getProcedureNames() {
        return new PpeProcedures();
    }

    @Override
    public Ppe execProcedureCreate(Ppe entity) {
        log.debug("Executing execProcedureCreate procedure.... " + PpeProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(PpeProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("ppeClassificationId", Integer.class, ParameterMode.IN);


        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("description", entity.getDescription());
        procedureQuery.setParameter("ppeClassificationId", null != entity.getPpeClassification() ? entity.getPpeClassification().getId() : null);

        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public Ppe execProcedureUpdate(Ppe entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + PpeProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(PpeProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("ppeClassificationId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("description", entity.getDescription());
        procedureQuery.setParameter("ppeClassificationId", null != entity.getPpeClassification() ? entity.getPpeClassification().getId() : null);

        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }
}
