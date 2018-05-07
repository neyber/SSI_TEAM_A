package com.groupa.ssi.services.catalog;/*
Created on 28/4/18
@author: HENRYBC
*/

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.model.repository.catalog.SaClassificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaClassificationService {

    private SaClassificationRepository repository;

    public SaClassificationService(SaClassificationRepository repository){
        this.repository = repository;
    }

    public List<SaClassification> findAll() {
        List<SaClassification> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public SaClassification findById(Integer id) {
        return (SaClassification) repository.findById(id).orElseThrow(() -> new DomainEntityNotFoundException(SaClassification.class));
    }

    public SaClassification save(SaClassification saClassification) {
        return repository.save(saClassification);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
