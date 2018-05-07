package com.groupa.ssi.model.repository.workitem;

import com.groupa.ssi.model.domain.workitem.ExistingWorkItemAssigned;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on May 7, 2018
 * @author Walker Colina
 */
public interface ExistingWorkItemAssignedRepository extends JpaRepository<ExistingWorkItemAssigned, Integer> {

}
