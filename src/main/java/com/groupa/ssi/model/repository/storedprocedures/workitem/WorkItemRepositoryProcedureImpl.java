package com.groupa.ssi.model.repository.storedprocedures.workitem;

import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.model.repository.storedprocedures.common.GenericRepositoryProcedureImpl;
import com.groupa.ssi.model.repository.storedprocedures.util.WorkItemProcedures;

/**
 * @author Miguel Rojas
 */
public class WorkItemRepositoryProcedureImpl
        extends GenericRepositoryProcedureImpl<WorkItem, WorkItemProcedures>
        implements WorkItemRepositoryProcedure {

    @Override
    public WorkItemProcedures getProcedureNames() {
        return new WorkItemProcedures();
    }

    @Override
    public void execProcedureCreate(WorkItem entity) {
        throw new UnsupportedOperationException("WorkItem procedure to execute create is pending ");
    }

    @Override
    public void execProcedureUpdate(WorkItem entity) {
        throw new UnsupportedOperationException("WorkItem procedure to execute create is pending");
    }
}
