package com.groupa.ssi.model.repository.storedprocedures.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.ExistingPpeProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.Date;

/*
Created on 3/6/18
@author: HENRYBC
*/
public class ExistingPpeRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<ExistingPpe, ExistingPpeProcedures>
        implements ExistingPpeRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ExistingPpeProcedures getProcedureNames() {
        return new ExistingPpeProcedures();
    }

    @Override
    public ExistingPpe execProcedureCreate(ExistingPpe entity) {
        log.debug("Executing execProcedureCreate procedure.... " + ExistingPpeProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(ExistingPpeProcedures.INSERT_NAME);
        procedureQuery.registerStoredProcedureParameter("detail", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("purchaseDate", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("lifeTimeDays", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("currentLifeTimeDays", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("ppeId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("detail", entity.getDetail());
        procedureQuery.setParameter("purchaseDate", entity.getPurchaseDate());
        procedureQuery.setParameter("lifeTimeDays", entity.getLifeTimeDays());
        procedureQuery.setParameter("currentLifeTimeDays", entity.getCurrentLifeTimeDays());
        procedureQuery.setParameter("ppeId", null != entity.getPpe() ? entity.getPpe().getId() : null);

        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public ExistingPpe execProcedureUpdate(ExistingPpe entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + ExistingPpeProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(ExistingPpeProcedures.UPDATE_NAME);
        procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("detail", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("purchaseDate", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("lifeTimeDays", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("currentLifeTimeDays", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("ppeId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("id", entity.getId());
        procedureQuery.setParameter("detail", entity.getDetail());
        procedureQuery.setParameter("purchaseDate", entity.getPurchaseDate());
        procedureQuery.setParameter("lifeTimeDays", entity.getLifeTimeDays());
        procedureQuery.setParameter("currentLifeTimeDays", entity.getCurrentLifeTimeDays());
        procedureQuery.setParameter("ppeId", null != entity.getPpe() ? entity.getPpe().getId() : null);

        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }
}
