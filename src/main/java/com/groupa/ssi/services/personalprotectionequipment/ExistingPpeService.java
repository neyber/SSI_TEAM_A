package com.groupa.ssi.services.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.repository.personalprotectionequipment.ExistingPpeRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
@Service
public class ExistingPpeService extends GenericService<ExistingPpe> {
    @Autowired
    private ExistingPpeRepository repository;

    @Override
    protected JpaRepository<ExistingPpe, Integer> getRepository() {
        return repository;
    }
}
