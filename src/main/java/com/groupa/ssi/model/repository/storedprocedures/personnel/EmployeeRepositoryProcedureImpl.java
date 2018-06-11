package com.groupa.ssi.model.repository.storedprocedures.personnel;

import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.EmployeeProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;

/**
 * @author Miguel Rojas
 */
public class EmployeeRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<Employee, EmployeeProcedures>
        implements EmployeeRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public EmployeeProcedures getProcedureNames() {
        return new EmployeeProcedures();
    }

    @Override
    public Employee execProcedureCreate(Employee entity) {
        log.debug("Executing execProcedureCreate procedure.... " + EmployeeProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(EmployeeProcedures.INSERT_NAME);
        registerBasicEntityParameters(procedureQuery, entity, false);

        //add common parameters for create
        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public Employee execProcedureUpdate(Employee entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + EmployeeProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(EmployeeProcedures.UPDATE_NAME);
        registerBasicEntityParameters(procedureQuery, entity, true);

        //add common parameters for update
        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());

    }

    private void registerBasicEntityParameters(StoredProcedureQuery procedureQuery, Employee entity, boolean isUpdate) {
        if (isUpdate) {
            procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            procedureQuery.setParameter("id", entity.getId());
        }

        procedureQuery.registerStoredProcedureParameter("identificationNumber", Long.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("firstName", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("lastName", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("dateOfBirth", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("gender", char.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("startDateInCompany", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("healthConditionStartingAtCompany", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("roleEmployeeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("supervisorId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("departmentEmployeeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("photoFileDocumentId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("identificationNumber", entity.getIdentificationNumber());
        procedureQuery.setParameter("firstName", entity.getFirstName());
        procedureQuery.setParameter("lastName", entity.getLastName());
        procedureQuery.setParameter("dateOfBirth", entity.getDateOfBirth());
        procedureQuery.setParameter("gender", entity.getGender());
        procedureQuery.setParameter("startDateInCompany", entity.getStartDateInCompany());
        procedureQuery.setParameter("healthConditionStartingAtCompany", entity.getHealthConditionStartingAtCompany());
        procedureQuery.setParameter("roleEmployeeId", entity.getRoleEmployee() != null ? entity.getRoleEmployee().getId() : null);
        procedureQuery.setParameter("supervisorId", entity.getSupervisor() != null ? entity.getSupervisor().getId() : null);
        procedureQuery.setParameter("departmentEmployeeId", entity.getDepartmentEmployee() != null ? entity.getDepartmentEmployee().getId() : null);
        procedureQuery.setParameter("photoFileDocumentId", entity.getPhotoFileDocument() != null ? entity.getPhotoFileDocument().getId() : null);
    }

}
