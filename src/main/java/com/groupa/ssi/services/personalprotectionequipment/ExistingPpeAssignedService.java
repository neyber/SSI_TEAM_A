package com.groupa.ssi.services.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpeAssigned;
import com.groupa.ssi.model.repository.personalprotectionequipment.ExistingPpeAssignedRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@Service
public class ExistingPpeAssignedService extends GenericService<ExistingPpeAssigned> {
    @Autowired
    private ExistingPpeAssignedRepository repository;

    @Override
    protected JpaRepository<ExistingPpeAssigned, Integer> getRepository() {
        return repository;
    }
}
