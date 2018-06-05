package com.groupa.ssi.model.repository.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpeAssigned;
import com.groupa.ssi.model.repository.storedprocedures.personalprotectionequipment.ExistingPpeAssignedRepositoryProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */

public interface ExistingPpeAssignedRepository extends JpaRepository<ExistingPpeAssigned, Integer>, ExistingPpeAssignedRepositoryProcedure {
}
