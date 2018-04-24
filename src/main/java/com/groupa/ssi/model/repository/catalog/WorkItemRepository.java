package com.groupa.ssi.model.repository.catalog;

import com.groupa.ssi.model.domain.catalog.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Miguel Rojas
 */
public interface WorkItemRepository extends JpaRepository<WorkItem, Integer> {

}
