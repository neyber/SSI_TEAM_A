package com.groupa.ssi.model.repository.storedprocedures.catalog;

import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.WorkItemClassificationProcedures;

/**
 * @author Miguel Rojas
 */
public class WorkItemClassificationRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<WorkItemClassification, WorkItemClassificationProcedures>
        implements WorkItemClassificationRepositoryProcedure {

    @Override
    public void execProcedureCreate(WorkItemClassification entity, WorkItemClassificationProcedures procedureNames) {
        throw new UnsupportedOperationException("procedure to execute create is pending");
    }

    @Override
    public void execProcedureUpdate(WorkItemClassification entity, WorkItemClassificationProcedures procedureNames) {
        throw new UnsupportedOperationException("procedure to execute update is pending");
    }
}
