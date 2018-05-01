package com.groupa.ssi.model.repository.workitem;

import com.groupa.ssi.model.domain.workitem.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Miguel Rojas
 */
public interface WorkItemRepository extends JpaRepository<WorkItem, Integer> {

}
