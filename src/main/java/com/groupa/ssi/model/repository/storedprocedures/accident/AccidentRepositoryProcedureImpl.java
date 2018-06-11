package com.groupa.ssi.model.repository.storedprocedures.accident;

import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.AccidentProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.Date;

/*
Created on 3/6/18
@author: HENRYBC
*/
public class AccidentRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<Accident, AccidentProcedures>
        implements AccidentRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public AccidentProcedures getProcedureNames() {
        return new AccidentProcedures();
    }

    @Override
    public Accident execProcedureCreate(Accident entity) {
        log.debug("Executing execProcedureCreate procedure.... " + AccidentProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(AccidentProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("dateAccident", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("whereOccurr", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("statusRecord", Boolean.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("totalDaysOutOfWork", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("totalDaysRestrictedTransferredWork", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("saCategoryId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("saTypeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN);


        procedureQuery.setParameter("description", entity.getDescription());
        procedureQuery.setParameter("dateAccident", entity.getDateAccident());
        procedureQuery.setParameter("whereOccurr", entity.getWhereOccurr());
        procedureQuery.setParameter("statusRecord",  null == entity.getStatusRecord() ? true : entity.getStatusRecord());
        procedureQuery.setParameter("totalDaysOutOfWork", entity.getTotalDaysOutOfWork());
        procedureQuery.setParameter("totalDaysRestrictedTransferredWork", entity.getTotalDaysRestrictedTransferredWork());
        procedureQuery.setParameter("saCategoryId", null != entity.getSaCategory() ? entity.getSaCategory().getId() : null);
        procedureQuery.setParameter("saTypeId", null != entity.getSaType() ? entity.getSaType().getId() : null);
        procedureQuery.setParameter("employeeId", null != entity.getEmployee() ? entity.getEmployee().getId() : null);


        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public Accident execProcedureUpdate(Accident entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + AccidentProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(AccidentProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("dateAccident", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("statusRecord", Boolean.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("whereOccurr", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("totalDaysOutOfWork", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("totalDaysRestrictedTransferredWork", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("saCategoryId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("saTypeId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("description", entity.getDescription());
        procedureQuery.setParameter("dateAccident", entity.getDateAccident());
        procedureQuery.setParameter("statusRecord", entity.getStatusRecord());
        procedureQuery.setParameter("whereOccurr", entity.getWhereOccurr());
        procedureQuery.setParameter("totalDaysOutOfWork", entity.getTotalDaysOutOfWork());
        procedureQuery.setParameter("totalDaysRestrictedTransferredWork", entity.getTotalDaysRestrictedTransferredWork());
        procedureQuery.setParameter("employeeId", null != entity.getEmployee() ? entity.getEmployee().getId() : null);
        procedureQuery.setParameter("saCategoryId", null != entity.getSaCategory() ? entity.getSaCategory().getId() : null);
        procedureQuery.setParameter("saTypeId", null != entity.getSaType() ? entity.getSaType().getId() : null);


        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }

}
