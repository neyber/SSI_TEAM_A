package com.groupa.ssi.services.saClassification;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.model.repository.saclassification.SaCategoryRepository;
import com.groupa.ssi.model.repository.workitem.WorkItemRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
Created on 13/5/18
@author: HENRYBC
*/
@Service
public class SaCategoryService extends GenericService<SaCategory> {

    @Autowired
    private SaCategoryRepository repository;

    @Override
    protected JpaRepository<SaCategory, Integer> getRepository() {
        return repository;
    }

}
