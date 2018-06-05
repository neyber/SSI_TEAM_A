package com.groupa.ssi.model.repository.storedprocedures.sickness;

import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.SicknessProcedures;
import com.groupa.ssi.model.repository.storedprocedures.util.WorkItemProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.Date;

/*
Created on 3/6/18
@author: HENRYBC
*/
public class SicknessRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<Sickness, SicknessProcedures>
        implements SicknessRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public SicknessProcedures getProcedureNames() {
        return new SicknessProcedures();
    }

    @Override
    public Sickness execProcedureCreate(Sickness entity) {
        log.debug("Executing execProcedureCreate procedure.... " + SicknessProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(SicknessProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("dateSickness", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("whereOccurr", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("statusRecord", Boolean.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("totalDaysOutOfWork", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("totalDaysRestrictedTransferredWork", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("saCategoryId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("saTypeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN);


        procedureQuery.setParameter("description", entity.getDescription());
        procedureQuery.setParameter("dateSickness", entity.getDateSickness());
        procedureQuery.setParameter("whereOccurr", entity.getWhereOccurr());
        procedureQuery.setParameter("statusRecord",  null == entity.getStatusRecord() ? true : entity.getStatusRecord());
        procedureQuery.setParameter("totalDaysOutOfWork", entity.getTotalDaysOutOfWork());
        procedureQuery.setParameter("totalDaysRestrictedTransferredWork", entity.getTotalDaysRestrictedTransferredWork());
        procedureQuery.setParameter("saCategoryId", null != entity.getSaCategory() ? entity.getSaCategory().getId() : null);
        procedureQuery.setParameter("saTypeId", null != entity.getSaType() ? entity.getSaType().getId() : null);
        procedureQuery.setParameter("employeeId", null != entity.getEmployee() ? entity.getEmployee().getId() : null);

        System.out.println("HENRY STARTING HERE");
        System.out.println(procedureQuery.getParameter("statusRecord").getPosition() +" 1 "+entity.getStatusRecord());
        System.out.println(procedureQuery.getParameter("totalDaysOutOfWork").getPosition() +" 2 "+entity.getTotalDaysOutOfWork());
        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public Sickness execProcedureUpdate(Sickness entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + SicknessProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(SicknessProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("dateSickness", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("whereOccurr", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("statusRecord", Boolean.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("totalDaysOutOfWork", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("totalDaysRestrictedTransferredWork", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("saCategoryId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("saTypeId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("description", entity.getDescription());
        procedureQuery.setParameter("dateSickness", entity.getDateSickness());
        procedureQuery.setParameter("whereOccurr", entity.getWhereOccurr());
        procedureQuery.setParameter("statusRecord", entity.getStatusRecord());
        procedureQuery.setParameter("totalDaysOutOfWork", entity.getTotalDaysOutOfWork());
        procedureQuery.setParameter("totalDaysRestrictedTransferredWork", entity.getTotalDaysRestrictedTransferredWork());
        procedureQuery.setParameter("saCategoryId", null != entity.getSaCategory() ? entity.getSaCategory().getId() : null);
        procedureQuery.setParameter("saTypeId", null != entity.getSaType() ? entity.getSaType().getId() : null);
        procedureQuery.setParameter("employeeId", null != entity.getEmployee() ? entity.getEmployee().getId() : null);



        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }
}
