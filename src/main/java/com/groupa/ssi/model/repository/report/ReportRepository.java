package com.groupa.ssi.model.repository.report;


import com.groupa.ssi.model.domain.catalog.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Linet Torrico
 */

public interface ReportRepository extends JpaRepository<WorkItem, Integer> {



}
