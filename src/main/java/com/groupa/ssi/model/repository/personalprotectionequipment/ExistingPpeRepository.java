package com.groupa.ssi.model.repository.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.repository.storedprocedures.personalprotectionequipment.ExistingPpeRepositoryProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */

public interface ExistingPpeRepository extends JpaRepository<ExistingPpe, Integer>, ExistingPpeRepositoryProcedure {
}
