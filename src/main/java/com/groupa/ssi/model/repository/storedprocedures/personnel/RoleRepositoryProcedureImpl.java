package com.groupa.ssi.model.repository.storedprocedures.personnel;

import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.DepartmentProcedures;
import com.groupa.ssi.model.repository.storedprocedures.util.RoleProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class RoleRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<Role, RoleProcedures>
        implements RoleRepositoryProcedure{

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Role execProcedureCreate(Role entity) {
        log.debug("Executing execProcedureCreate procedure.... " + RoleProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(RoleProcedures.INSERT_NAME);
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
    public Role execProcedureUpdate(Role entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + RoleProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(RoleProcedures.UPDATE_NAME);
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
    public RoleProcedures getProcedureNames() {
        return new RoleProcedures();
    }
}
