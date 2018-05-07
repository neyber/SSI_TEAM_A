package com.groupa.ssi.services.personnel;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.model.repository.personnel.RoleRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lizeth Salazar
 */

@Service
public class RoleService extends GenericService<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    protected JpaRepository<Role, Integer> getRepository() {return roleRepository;}
}
