package com.groupa.ssi.model.repository.workitem;

import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.model.repository.storedprocedures.workitem.WorkItemRepositoryProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Miguel Rojas
 */
public interface WorkItemRepository extends JpaRepository<WorkItem, Integer>, WorkItemRepositoryProcedure {

}
