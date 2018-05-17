package com.groupa.ssi.model.repository.catalog;

import com.groupa.ssi.model.domain.saClassification.SaClassification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaClassificationRepository extends JpaRepository<SaClassification, Integer> {
}
