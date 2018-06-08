package com.groupa.ssi.services.saClassification;

import com.groupa.ssi.model.domain.saClassification.SaType;
import com.groupa.ssi.model.repository.saclassification.SaTypeRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/*
Created on 13/5/18
@author: HENRYBC
*/
@Service
public class SaTypeService extends GenericService<SaType> {

    @Autowired
    private SaTypeRepository repository;

    @Override
    protected JpaRepository<SaType, Integer> getRepository() {
        return repository;
    }
}
