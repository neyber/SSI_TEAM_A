/**
 * @author: Miguel Rojas
 */
package com.groupa.ssi.model.repository.storedprocedures.workitem;

import com.groupa.ssi.model.domain.workitem.ExistingWorkItem;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.ExistingWorkItemProcedures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;

public class ExistingWorkItemRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<ExistingWorkItem, ExistingWorkItemProcedures>
        implements ExistingWorkItemRepositoryProcedure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ExistingWorkItemProcedures getProcedureNames() {
        return new ExistingWorkItemProcedures();
    }

    @Override
    public ExistingWorkItem execProcedureCreate(ExistingWorkItem entity) {
        log.debug("Executing execProcedureCreate procedure.... " + ExistingWorkItemProcedures.INSERT_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(ExistingWorkItemProcedures.INSERT_NAME);
        registerBasicEntityParameters(procedureQuery, entity, false);

        //add common parameters for create
        addCreateCommonParameters(procedureQuery);

        procedureQuery.execute();

        Integer newId = getNewIdAsOutPutParameter(procedureQuery);
        return execProcedureFindById(newId);
    }

    @Override
    public ExistingWorkItem execProcedureUpdate(ExistingWorkItem entity) {
        log.debug("Executing execProcedureUpdate procedure.... " + ExistingWorkItemProcedures.UPDATE_NAME);

        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery(ExistingWorkItemProcedures.UPDATE_NAME);
        registerBasicEntityParameters(procedureQuery, entity, true);

        //add common parameters for update
        addUpdateCommonParameters(procedureQuery, entity);

        procedureQuery.execute();

        return execProcedureFindById(entity.getId());
    }

    private void registerBasicEntityParameters(StoredProcedureQuery procedureQuery, ExistingWorkItem entity, boolean isUpdate) {
        if (isUpdate) {
            procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            procedureQuery.setParameter("id", entity.getId());
        }

        procedureQuery.registerStoredProcedureParameter("detail", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("purchaseDate", Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("serieNo", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("workItemId", Integer.class, ParameterMode.IN);

        procedureQuery.setParameter("detail", entity.getDetail());
        procedureQuery.setParameter("purchaseDate", entity.getPurchaseDate());
        procedureQuery.setParameter("serieNo", entity.getSerieNo());
        procedureQuery.setParameter("workItemId", entity.getWorkItem() != null ? entity.getWorkItem().getId() : null);
    }
}

