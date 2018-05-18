package com.groupa.ssi.services.saClassification;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.repository.saclassification.SaCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
Created on 13/5/18
@author: HENRYBC
*/
@Service
public class SaCategoryService {

    private SaCategoryRepository repository;

    public SaCategoryService(SaCategoryRepository repository) {
        this.repository = repository;
    }

    public List<SaCategory> findAll() {
        List<SaCategory> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public SaCategory findById(Integer id) {
        return (SaCategory) repository.findById(id).orElseThrow(() -> new DomainEntityNotFoundException(SaCategory.class));
    }

    public SaCategory save(SaCategory saCategory) {
        return repository.save(saCategory);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
