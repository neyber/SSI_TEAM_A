/*
@author: HENRYBC
*/
package com.groupa.ssi.services.accident;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.repository.accident.AccidentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentService {

    private AccidentRepository repository;

    public AccidentService(AccidentRepository repository) {
        this.repository = repository;
    }

    public List<Accident> findAll() {
        List<Accident> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public Accident findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new DomainEntityNotFoundException(Accident.class));
    }

    public Accident save(Accident accident) {
        return repository.save(accident);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
