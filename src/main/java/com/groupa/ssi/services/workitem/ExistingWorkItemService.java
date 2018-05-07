package com.groupa.ssi.services.workitem;

import com.groupa.ssi.model.domain.workitem.ExistingWorkItem;
import com.groupa.ssi.model.repository.workitem.ExistingWorkItemRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@Service
public class ExistingWorkItemService extends GenericService<ExistingWorkItem> {
    @Autowired
    private ExistingWorkItemRepository repository;

    @Override
    protected JpaRepository<ExistingWorkItem, Integer> getRepository() {
        return repository;
    }
}
