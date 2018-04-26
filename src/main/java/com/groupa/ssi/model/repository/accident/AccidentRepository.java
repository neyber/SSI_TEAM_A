package com.groupa.ssi.model.repository.accident;

import com.groupa.ssi.model.domain.accident.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Integer> {
}
