package com.groupa.ssi.model.repository.saclassification;

import com.groupa.ssi.model.domain.saClassification.SaType;
import com.groupa.ssi.model.repository.storedprocedures.saClassification.SaTypeRepositoryProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Created on 13/5/18
@author: HENRYBC
*/
public interface SaTypeRepository extends JpaRepository<SaType, Integer>, SaTypeRepositoryProcedure {
}
