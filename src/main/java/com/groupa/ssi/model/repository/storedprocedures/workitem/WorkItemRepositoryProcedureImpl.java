package com.groupa.ssi.model.repository.storedprocedures.workitem;

import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.WorkItemClassificationProcedures;
import com.groupa.ssi.model.repository.storedprocedures.util.WorkItemProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 * @author Miguel Rojas
 */
public class WorkItemRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<WorkItem, WorkItemProcedures>
        implements WorkItemRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public WorkItemProcedures getProcedureNames() {
        return new WorkItemProcedures();
    }

    @Override
    public WorkItem execProcedureCreate(WorkItem entity) {
        log.debug("Executing execProcedureCreate procedure.... " + WorkItemProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(WorkItemProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("workItemClassificationId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("description", entity.getDescription());
        procedureQuery.setParameter("workItemClassificationId", entity.getWorkItemClassification() != null ? entity.getWorkItemClassification().getId() : null);

        //add common parameters for create
        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public WorkItem execProcedureUpdate(WorkItem entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + WorkItemProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(WorkItemProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("workItemClassificationId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("description", entity.getDescription());
        procedureQuery.setParameter("workItemClassificationId", entity.getWorkItemClassification() != null ? entity.getWorkItemClassification().getId() : null);

        //add common parameters for update
        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }
}
