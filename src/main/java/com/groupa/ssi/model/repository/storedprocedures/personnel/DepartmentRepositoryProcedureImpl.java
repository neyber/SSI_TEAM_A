package com.groupa.ssi.model.repository.storedprocedures.personnel;

import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.DepartmentProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class DepartmentRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<Department, DepartmentProcedures>
        implements DepartmentRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Department execProcedureCreate(Department entity) {
        log.debug("Executing execProcedureCreate procedure.... " + DepartmentProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(DepartmentProcedures.INSERT_NAME);
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
    public Department execProcedureUpdate(Department entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + DepartmentProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(DepartmentProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("description", entity.getDescription());

        //add common parameters for create
        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }

    @Override
    public DepartmentProcedures getProcedureNames() {
        return new DepartmentProcedures();
    }
}
