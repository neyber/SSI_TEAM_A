package com.groupa.ssi.model.repository.storedprocedures.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpeAssigned;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.ExistingPpeAssignedProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;

/*
Created on 3/6/18
@author: HENRYBC
*/
public class ExistingPpeAssignedRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<ExistingPpeAssigned, ExistingPpeAssignedProcedures>
        implements ExistingPpeAssignedRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ExistingPpeAssignedProcedures getProcedureNames() {
        return new ExistingPpeAssignedProcedures();
    }

    @Override
    public ExistingPpeAssigned execProcedureCreate(ExistingPpeAssigned entity) {
        log.debug("Executing execProcedureCreate procedure.... " + ExistingPpeAssignedProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(ExistingPpeAssignedProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("assignedNotes", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("assignedDate", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("returnNotes", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("returnDate", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("existingPpeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("assignedNotes", entity.getAssignedNotes());
        procedureQuery.setParameter("assignedDate", entity.getAssignedDate());
        procedureQuery.setParameter("returnNotes", entity.getReturnNotes());
        procedureQuery.setParameter("returnDate", entity.getReturnDate());
        procedureQuery.setParameter("existingPpeId", null != entity.getExistingPpe() ? entity.getExistingPpe().getId() : null);
        procedureQuery.setParameter("employeeId", null != entity.getEmployee() ? entity.getEmployee().getId() : null);

        System.out.println(entity.getAssignedNotes());
        System.out.println(entity.getAssignedDate());
        System.out.println(entity.getReturnNotes());
        System.out.println(entity.getReturnDate());
        System.out.println(entity.getExistingPpe().getId());

        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public ExistingPpeAssigned execProcedureUpdate(ExistingPpeAssigned entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + ExistingPpeAssignedProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(ExistingPpeAssignedProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("assignedNotes", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("assignedDate", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("returnNotes", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("returnDate", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("existingPpeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("assignedNotes", entity.getAssignedNotes());
        procedureQuery.setParameter("assignedDate", entity.getAssignedDate());
        procedureQuery.setParameter("returnNotes", entity.getReturnNotes());
        procedureQuery.setParameter("returnDate", entity.getReturnDate());
        procedureQuery.setParameter("existingPpeId", null != entity.getExistingPpe() ? entity.getExistingPpe().getId() : null);
        procedureQuery.setParameter("employeeId", null != entity.getEmployee() ? entity.getEmployee().getId() : null);

        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }
}
