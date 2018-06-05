package com.groupa.ssi.model.repository.storedprocedures.audit;

import com.groupa.ssi.model.domain.audit.SafetyRule;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.SafetyRuleProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class SafetyRuleRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<SafetyRule, SafetyRuleProcedures>
        implements SafetyRuleRepositoryProcedure{

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public SafetyRule execProcedureCreate(SafetyRule entity) {
        log.debug("Executing execProcedureCreate procedure.... " + SafetyRuleProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(SafetyRuleProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("accomplishment", Boolean.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("complianceMetric", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("complianceParameter", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("policyCode", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("policyName", String.class, ParameterMode.IN);

        procedureQuery.setParameter("accomplishment", entity.getAccomplishment());
        procedureQuery.setParameter("auditId", entity.getAudit() != null ? entity.getAudit().getId() : null);
        procedureQuery.setParameter("complianceMetric", entity.getComplianceMetric());
        procedureQuery.setParameter("complianceParameter", entity.getComplianceParameter());
        procedureQuery.setParameter("policyCode", entity.getPolicyCode());
        procedureQuery.setParameter("policyName", entity.getPolicyName());

        //add common parameters for create
        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public SafetyRule execProcedureUpdate(SafetyRule entity) {
        log.debug("Executing execProcedureCreate procedure.... " + SafetyRuleProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(SafetyRuleProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("accomplishment", Boolean.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("complianceMetric", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("complianceParameter", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("policyCode", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("policyName", String.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("accomplishment", entity.getAccomplishment());
        procedureQuery.setParameter("auditId", entity.getAudit() != null ? entity.getAudit().getId() : null);
        procedureQuery.setParameter("complianceMetric", entity.getComplianceMetric());
        procedureQuery.setParameter("complianceParameter", entity.getComplianceParameter());
        procedureQuery.setParameter("policyCode", entity.getPolicyCode());
        procedureQuery.setParameter("policyName", entity.getPolicyName());

        //add common parameters for create
        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }

    @Override
    public SafetyRuleProcedures getProcedureNames() {
        return new SafetyRuleProcedures();
    }
}
