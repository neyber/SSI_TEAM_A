package com.groupa.ssi.services.personalprotectionequipment;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.repository.personalprotectionequipment.ExistingPpeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
@Service
public class ExistingPpeService {
    private ExistingPpeRepository repository;

    public ExistingPpeService(ExistingPpeRepository repository) {
        this.repository = repository;
    }

    public List<ExistingPpe> findAll() {
        List<ExistingPpe> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public ExistingPpe findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new DomainEntityNotFoundException(ExistingPpe.class));
    }

    public ExistingPpe save(ExistingPpe existingPpe) {
        return repository.save(existingPpe);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
