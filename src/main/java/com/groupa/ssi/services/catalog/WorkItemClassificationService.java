package com.groupa.ssi.services.catalog;

import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.model.repository.catalog.WorkItemClassificationRepository;
import com.groupa.ssi.model.repository.storedprocedures.util.WorkItemClassificationProcedures;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@Service
public class WorkItemClassificationService extends GenericService<WorkItemClassification> {
    @Autowired
    private WorkItemClassificationRepository repository;

    @Override
    protected JpaRepository<WorkItemClassification, Integer> getRepository() {
        return repository;
    }

    public List<WorkItemClassification> getAll() {
        return repository.executeAll(new WorkItemClassificationProcedures());
    }
}
