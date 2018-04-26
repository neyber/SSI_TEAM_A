package com.groupa.ssi.services.catalog;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.repository.catalog.PpeClassificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Service
public class PpeClassificationService {
    private PpeClassificationRepository repository;

    public PpeClassificationService(PpeClassificationRepository repository) {
        this.repository = repository;
    }

    public List<PpeClassification> findAll() {
        List<PpeClassification> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public PpeClassification findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new DomainEntityNotFoundException(PpeClassification.class));
    }

    public PpeClassification save(PpeClassification ppeClassification) {
        return repository.save(ppeClassification);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
