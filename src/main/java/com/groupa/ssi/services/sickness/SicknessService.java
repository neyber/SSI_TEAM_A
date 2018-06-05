/*
@author: HENRYBC
*/
package com.groupa.ssi.services.sickness;

import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.model.repository.sickness.SicknessRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SicknessService extends GenericService<Sickness> {

    @Autowired
    private SicknessRepository repository;

    @Override
    protected JpaRepository<Sickness, Integer> getRepository() {
        return repository;
    }


}
