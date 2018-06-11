package com.groupa.ssi.model.repository.saclassification;

import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.repository.storedprocedures.saClassification.SaCategoryRepositoryProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Created on 13/5/18
@author: HENRYBC
*/
public interface SaCategoryRepository extends JpaRepository<SaCategory, Integer>, SaCategoryRepositoryProcedure {
}
