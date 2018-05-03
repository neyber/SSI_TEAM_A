package com.groupa.ssi.services.workitem;

import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.model.repository.workitem.WorkItemRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Miguel Rojas
 */
@Service
public class WorkItemService extends GenericService<WorkItem> {

    @Autowired
    private WorkItemRepository repository;

    @Override
    protected JpaRepository<WorkItem, Integer> getRepository() {
        return repository;
    }
}
