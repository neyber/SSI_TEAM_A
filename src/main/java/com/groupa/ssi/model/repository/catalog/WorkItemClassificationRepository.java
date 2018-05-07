package com.groupa.ssi.model.repository.catalog;

import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */

public interface WorkItemClassificationRepository extends JpaRepository<WorkItemClassification, Integer> {
}
