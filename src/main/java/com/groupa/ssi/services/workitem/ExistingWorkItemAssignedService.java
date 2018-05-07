package com.groupa.ssi.services.workitem;

import com.groupa.ssi.model.domain.workitem.ExistingWorkItemAssigned;
import com.groupa.ssi.model.repository.workitem.ExistingWorkItemAssignedRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created on May 7, 2018
 * @author Walker Colina
 */
@Service
public class ExistingWorkItemAssignedService extends GenericService<ExistingWorkItemAssigned> {
    @Autowired
    private ExistingWorkItemAssignedRepository repository;

    @Override
    protected JpaRepository<ExistingWorkItemAssigned, Integer> getRepository() {
        return repository;
    }
}
