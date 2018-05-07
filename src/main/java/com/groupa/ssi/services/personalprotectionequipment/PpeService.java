package com.groupa.ssi.services.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.model.repository.personalprotectionequipment.PpeRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Service
public class PpeService extends GenericService<Ppe> {
    @Autowired
    private PpeRepository repository;

    @Override
    protected JpaRepository<Ppe, Integer> getRepository() {
        return repository;
    }
}
