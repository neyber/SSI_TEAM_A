package com.groupa.ssi.services.catalog;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.model.repository.catalog.WorkItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miguel Rojas
 */
@Service
public class WorkItemService {

    private WorkItemRepository repository;

    public WorkItemService(WorkItemRepository repository) {
        this.repository = repository;
    }

    public List<WorkItem> findAll() {
        List<WorkItem> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public WorkItem findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new DomainEntityNotFoundException(WorkItem.class));
    }

    public WorkItem save(WorkItem workItem) {
        return repository.save(workItem);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
