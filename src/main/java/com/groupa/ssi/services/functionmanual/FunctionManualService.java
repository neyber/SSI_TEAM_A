package com.groupa.ssi.services.functionmanual;



import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import com.groupa.ssi.model.repository.functionmanual.FunctionManualRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;



/**
 * @author Marcelo Loayza
 */

@Service
public class FunctionManualService extends GenericService<FunctionManual> {

    @Autowired
    private FunctionManualRepository functionManualRepository;

    @Override
    protected JpaRepository<FunctionManual, Integer> getRepository() {
        return functionManualRepository;
    }
}
