package com.groupa.ssi.services.usermanual;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import com.groupa.ssi.model.repository.functionmanual.FunctionManualRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcelo Loayza
 */

@Service
public class UserManualService {

    private FunctionManualRepository functionManualRepository;

    public UserManualService(FunctionManualRepository functionManualRepository) {
        this.functionManualRepository = functionManualRepository;
    }

    public List<FunctionManual> findAll(){
        List<FunctionManual> functionManuals = new ArrayList();
        functionManualRepository.findAll().forEach(functionManuals::add);
        return functionManuals;
    }

    public FunctionManual findById(Integer userManualId){
        return functionManualRepository.findById(userManualId).orElseThrow(() -> new DomainEntityNotFoundException(FunctionManual.class));
    }

    public FunctionManual save(FunctionManual functionManual){ return functionManualRepository.save(functionManual);
    }

    public void deleteById(Integer userManualId){
        functionManualRepository.deleteById(userManualId);
    }
}
