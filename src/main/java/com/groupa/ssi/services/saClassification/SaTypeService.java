package com.groupa.ssi.services.saClassification;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.domain.saClassification.SaType;
import com.groupa.ssi.model.repository.saclassification.SaCategoryRepository;
import com.groupa.ssi.model.repository.saclassification.SaTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
Created on 13/5/18
@author: HENRYBC
*/
@Service
public class SaTypeService {

    private SaTypeRepository repository;

    public SaTypeService(SaTypeRepository repository) {
        this.repository = repository;
    }

    public List<SaType> findAll() {
        List<SaType> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public SaType findById(Integer id) {
        return (SaType) repository.findById(id).orElseThrow(() -> new DomainEntityNotFoundException(SaType.class));
    }

    public SaType save(SaType saType) {
        return repository.save(saType);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
