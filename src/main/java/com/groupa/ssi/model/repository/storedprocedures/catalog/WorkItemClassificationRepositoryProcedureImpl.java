package com.groupa.ssi.model.repository.storedprocedures.catalog;

import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.WorkItemClassificationProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 * @author Miguel Rojas
 */
public class WorkItemClassificationRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<WorkItemClassification, WorkItemClassificationProcedures>
        implements WorkItemClassificationRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public WorkItemClassificationProcedures getProcedureNames() {
        return new WorkItemClassificationProcedures();
    }

    @Override
    public WorkItemClassification execProcedureCreate(WorkItemClassification entity) {
        log.debug("Executing execProcedureCreate procedure.... " + WorkItemClassificationProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(WorkItemClassificationProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);

        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("description", entity.getDescription());

        //add common parameters for create
        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public WorkItemClassification execProcedureUpdate(WorkItemClassification entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + WorkItemClassificationProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(WorkItemClassificationProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("description", entity.getDescription());

        //add common parameters for update
        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }
}
