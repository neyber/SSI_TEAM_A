package com.groupa.ssi.services.personalprotectionequipment;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.model.repository.personalprotectionequipment.PpeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Service
public class PpeService {
    private PpeRepository repository;

    public PpeService(PpeRepository repository) {
        this.repository = repository;
    }

    public List<Ppe> findAll() {
        List<Ppe> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public Ppe findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new DomainEntityNotFoundException(Ppe.class));
    }

    public Ppe save(Ppe ppe) {
        return repository.save(ppe);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
