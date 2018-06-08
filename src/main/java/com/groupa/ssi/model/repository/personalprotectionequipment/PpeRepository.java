package com.groupa.ssi.model.repository.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.model.repository.storedprocedures.personalprotectionequipment.PpeRepositoryProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */

public interface PpeRepository extends JpaRepository<Ppe, Integer>, PpeRepositoryProcedure {
}
