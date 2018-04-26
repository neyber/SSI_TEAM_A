package com.groupa.ssi.services.usermanual;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.usermanual.UserManual;
import com.groupa.ssi.model.repository.usermanual.UserManualRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcelo Loayza
 */

@Service
public class UserManualService {

    private UserManualRepository userManualRepository;

    public UserManualService(UserManualRepository userManualRepository) {
        this.userManualRepository = userManualRepository;
    }

    public List<UserManual> findAll(){
        List<UserManual> userManuals = new ArrayList();
        userManualRepository.findAll().forEach(userManuals::add);
        return userManuals;
    }

    public UserManual findById(Integer userManualId){
        return userManualRepository.findById(userManualId).orElseThrow(() -> new DomainEntityNotFoundException(UserManual.class));
    }

    public UserManual save(UserManual userManual){ return userManualRepository.save(userManual);
    }

    public void deleteById(Integer userManualId){
        userManualRepository.deleteById(userManualId);
    }
}
