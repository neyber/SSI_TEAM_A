package com.groupa.ssi.model.repository.catalog;

import com.groupa.ssi.model.domain.catalog.WorkItemClassification;

import java.util.List;

/**
 * @author Miguel Rojas
 */
public interface WorkItemClassificationProcedureRepository {


    public List<WorkItemClassification> getAll();
}
