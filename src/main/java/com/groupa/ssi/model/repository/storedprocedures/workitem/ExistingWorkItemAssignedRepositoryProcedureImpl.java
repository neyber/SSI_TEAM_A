package com.groupa.ssi.model.repository.storedprocedures.workitem;

import com.groupa.ssi.model.domain.workitem.ExistingWorkItemAssigned;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.ExistingWorkItemAssignedProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;

/**
 * @author Miguel Rojas
 */
public class ExistingWorkItemAssignedRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<ExistingWorkItemAssigned, ExistingWorkItemAssignedProcedures>
        implements ExistingWorkItemAssignedRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ExistingWorkItemAssignedProcedures getProcedureNames() {
        return new ExistingWorkItemAssignedProcedures();
    }

    @Override
    public ExistingWorkItemAssigned execProcedureCreate(ExistingWorkItemAssigned entity) {
        log.debug("Executing execProcedureCreate procedure.... " + ExistingWorkItemAssignedProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(ExistingWorkItemAssignedProcedures.INSERT_NAME);
        registerBasicEntityParameters(procedureQuery, entity, false);

        //add common parameters for create
        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public ExistingWorkItemAssigned execProcedureUpdate(ExistingWorkItemAssigned entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + ExistingWorkItemAssignedProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(ExistingWorkItemAssignedProcedures.UPDATE_NAME);
        registerBasicEntityParameters(procedureQuery, entity, true);

        //add common parameters for update
        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }

    private void registerBasicEntityParameters(StoredProcedureQuery procedureQuery, ExistingWorkItemAssigned entity, boolean isUpdate) {
        if (isUpdate) {
            procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            procedureQuery.setParameter("id", entity.getId());
        }

        procedureQuery.registerStoredProcedureParameter("assignedNotes", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("assignedDate", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("returnNotes", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("returnDate", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("existingWorkItemId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("assignedNotes", entity.getAssignedNotes());
        procedureQuery.setParameter("assignedDate", entity.getAssignedDate());
        procedureQuery.setParameter("returnNotes", entity.getReturnNotes());
        procedureQuery.setParameter("returnDate", entity.getReturnDate());
        procedureQuery.setParameter("employeeId", entity.getEmployee() != null ? entity.getEmployee().getId() : null);
        procedureQuery.setParameter("existingWorkItemId", entity.getExistingWorkItem() != null ? entity.getExistingWorkItem().getId() : null);
    }

}
