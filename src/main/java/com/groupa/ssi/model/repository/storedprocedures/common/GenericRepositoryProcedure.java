package com.groupa.ssi.model.repository.storedprocedures.common;

import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.model.repository.storedprocedures.util.GenericProcedureNames;

import java.util.List;

/**
 * @author Miguel Rojas
 */
public interface GenericRepositoryProcedure<T> {
    public List<T> executeAll(GenericProcedureNames procedureNames);
}
