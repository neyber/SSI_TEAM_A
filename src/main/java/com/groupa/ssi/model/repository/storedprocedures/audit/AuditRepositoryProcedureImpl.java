package com.groupa.ssi.model.repository.storedprocedures.audit;

import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.AuditProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class AuditRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<Audit, AuditProcedures>
        implements AuditRepositoryProcedure{

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Audit execProcedureCreate(Audit entity) {
        log.debug("Executing execProcedureCreate procedure.... " + AuditProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(AuditProcedures.INSERT_NAME);

        procedureQuery.registerStoredProcedureParameter("auditCode", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditCriteria", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditName", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditObjective", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditScope", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditType", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("departmentId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("periodicity", String.class, ParameterMode.IN);


        procedureQuery.setParameter("auditCode", entity.getAuditCode());
        procedureQuery.setParameter("auditCriteria", entity.getAuditCriteria());
        procedureQuery.setParameter("auditName", entity.getAuditName());
        procedureQuery.setParameter("auditObjective", entity.getAuditObjective());
        procedureQuery.setParameter("auditScope", entity.getAuditScope());
        procedureQuery.setParameter("auditType", entity.getAuditType());
        procedureQuery.setParameter("departmentId", entity.getDepartment() != null ? entity.getDepartment().getId() : null);
        procedureQuery.setParameter("employeeId", entity.getEmployee() != null ? entity.getEmployee().getId() : null);
        procedureQuery.setParameter("periodicity", entity.getPeriodicity());

        //add common parameters for create
        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public Audit execProcedureUpdate(Audit entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + AuditProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(AuditProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditCode", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditCriteria", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditName", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditObjective", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditScope", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("auditType", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("departmentId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("periodicity", String.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("auditCode", entity.getAuditCode());
        procedureQuery.setParameter("auditCriteria", entity.getAuditCriteria());
        procedureQuery.setParameter("auditName", entity.getAuditName());
        procedureQuery.setParameter("auditObjective", entity.getAuditObjective());
        procedureQuery.setParameter("auditScope", entity.getAuditScope());
        procedureQuery.setParameter("auditType", entity.getAuditType());
        procedureQuery.setParameter("departmentId", entity.getDepartment() != null ? entity.getDepartment().getId() : null);
        procedureQuery.setParameter("employeeId", entity.getEmployee() != null ? entity.getEmployee().getId() : null);
        procedureQuery.setParameter("periodicity", entity.getPeriodicity());

        //add common parameters for create
        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }

    @Override
    public AuditProcedures getProcedureNames() {
        return new AuditProcedures();
    }
}
