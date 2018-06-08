package com.groupa.ssi.model.repository.sickness;

import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.model.repository.storedprocedures.sickness.SicknessRepositoryProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SicknessRepository extends JpaRepository<Sickness, Integer>, SicknessRepositoryProcedure {
}
