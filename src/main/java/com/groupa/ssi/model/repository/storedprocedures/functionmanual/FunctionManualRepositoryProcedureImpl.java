package com.groupa.ssi.model.repository.storedprocedures.functionmanual;

import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.FunctionManualProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class FunctionManualRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<FunctionManual, FunctionManualProcedures>
        implements FunctionManualRepositoryProcedure{

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public FunctionManual execProcedureCreate(FunctionManual entity) {
        log.debug("Executing execProcedureCreate procedure.... " + FunctionManualProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(FunctionManualProcedures.INSERT_NAME);

        procedureQuery.registerStoredProcedureParameter("dependentPersonal", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("externalRelation", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("generalActivity", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("hierarchicalLever", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("internalRelation", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("position", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("principalFunction", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("roleFunctionId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("superiorBoss", String.class, ParameterMode.IN);

        procedureQuery.setParameter("dependentPersonal", entity.getDependentPersonal());
        procedureQuery.setParameter("externalRelation", entity.getExternalRelation());
        procedureQuery.setParameter("generalActivity", entity.getGeneralActivity());
        procedureQuery.setParameter("hierarchicalLever", entity.getHierarchicalLever());
        procedureQuery.setParameter("internalRelation", entity.getInternalRelation());
        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("position", entity.getPosition());
        procedureQuery.setParameter("principalFunction", entity.getPrincipalFunction());
        procedureQuery.setParameter("roleFunctionId", entity.getRoleFunction() != null ? entity.getRoleFunction().getId() : null);
        procedureQuery.setParameter("superiorBoss", entity.getSuperiorBoss());

        //add common parameters for create
        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public FunctionManual execProcedureUpdate(FunctionManual entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + FunctionManualProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(FunctionManualProcedures.UPDATE_NAME);

        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("dependentPersonal", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("externalRelation", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("generalActivity", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("hierarchicalLever", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("internalRelation", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("position", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("principalFunction", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("roleFunctionId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("superiorBoss", String.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("dependentPersonal", entity.getDependentPersonal());
        procedureQuery.setParameter("externalRelation", entity.getExternalRelation());
        procedureQuery.setParameter("generalActivity", entity.getGeneralActivity());
        procedureQuery.setParameter("hierarchicalLever", entity.getHierarchicalLever());
        procedureQuery.setParameter("internalRelation", entity.getInternalRelation());
        procedureQuery.setParameter("name", entity.getName());
        procedureQuery.setParameter("position", entity.getPosition());
        procedureQuery.setParameter("principalFunction", entity.getPrincipalFunction());
        procedureQuery.setParameter("roleFunctionId", entity.getRoleFunction() != null ? entity.getRoleFunction().getId() : null);
        procedureQuery.setParameter("superiorBoss", entity.getSuperiorBoss());

        //add common parameters for create
        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }

    @Override
    public FunctionManualProcedures getProcedureNames() {
        return new FunctionManualProcedures();
    }
}
