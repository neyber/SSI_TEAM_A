/*
@author: HENRYBC
*/
package com.groupa.ssi.services.accident;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.repository.accident.AccidentRepository;
import com.groupa.ssi.model.repository.saclassification.SaCategoryRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentService extends GenericService<Accident> {

    @Autowired
    private AccidentRepository repository;

    @Override
    protected JpaRepository<Accident, Integer> getRepository() {
        return repository;
    }


}
