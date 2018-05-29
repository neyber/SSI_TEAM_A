package com.groupa.ssi.model.repository.storedprocedures.common;

import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.model.repository.storedprocedures.util.GenericProcedureNames;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/**
 * @author Miguel Rojas
 */
public class GenericRepositoryProcedureImpl<T> implements GenericRepositoryProcedure<T> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<T> executeAll(GenericProcedureNames procedureNames) {
        //StoredProcedureQuery findByYearProcedure = em.createNamedStoredProcedureQuery(K.allProcedureName());
        StoredProcedureQuery findByYearProcedure = em.createNamedStoredProcedureQuery(procedureNames.allProcedureName());

        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQ222222" + findByYearProcedure.getResultList());
        for (int i = 0; i < findByYearProcedure.getResultList().size(); i++) {
            Object o = findByYearProcedure.getResultList().get(i);
            System.out.println("aaaaaaa:"+ o);
            System.out.println("aaaaaaa:"+ o.getClass());
        }

        return  findByYearProcedure.getResultList();
    }
}
