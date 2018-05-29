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

        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQ" + findByYearProcedure.getResultList());
        for (int i = 0; i < findByYearProcedure.getResultList().size(); i++) {
            Object o = findByYearProcedure.getResultList().get(i);
            System.out.println("aaaaaaa:"+ o);
            System.out.println("aaaaaaa:"+ o.getClass());
        }


        return (List<WorkItemClassification>) findByYearProcedure.getResultList();
    }
}
