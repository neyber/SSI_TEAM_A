package com.groupa.ssi.model.repository.usermanual;


import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManualRepository extends JpaRepository<FunctionManual, Integer> {
}
