package com.groupa.ssi.model.repository.catalog;

import com.groupa.ssi.model.domain.catalog.WorkItemClassification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/**
 * @author Miguel Rojas
 */
public class WorkItemClassificationRepositoryImpl implements WorkItemClassificationProcedureRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<WorkItemClassification> getAll() {
        StoredProcedureQuery findByYearProcedure = em.createNamedStoredProcedureQuery("getAllWorkItemClassification");
        return (List<WorkItemClassification>) findByYearProcedure.getResultList();
    }
}
