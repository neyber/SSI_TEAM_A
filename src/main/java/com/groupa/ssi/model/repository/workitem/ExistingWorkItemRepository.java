package com.groupa.ssi.model.repository.workitem;

import com.groupa.ssi.model.domain.workitem.ExistingWorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
public interface ExistingWorkItemRepository extends JpaRepository<ExistingWorkItem, Integer> {

}
