package com.groupa.ssi.model.repository.functionmanual;


import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import com.groupa.ssi.model.repository.storedprocedures.functionmanual.FunctionManualRepositoryProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marcelo Loayza
 */
public interface FunctionManualRepository extends JpaRepository<FunctionManual, Integer>, FunctionManualRepositoryProcedure {
}
