/*
@author: HENRYBC
*/
package com.groupa.ssi.services.sickness;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.model.repository.sickness.SicknessRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SicknessService {
    private SicknessRepository repository;

    public SicknessService(SicknessRepository repository) {
        this.repository = repository;
    }

    public List<Sickness> findAll() {
        List<Sickness> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public Sickness findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new DomainEntityNotFoundException(Sickness.class));
    }

    public Sickness save(Sickness sickness) {
        return repository.save(sickness);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
