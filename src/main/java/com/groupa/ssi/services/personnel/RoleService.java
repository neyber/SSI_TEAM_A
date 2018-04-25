package com.groupa.ssi.services.personnel;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.model.repository.personnel.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lizeth Salazar
 */

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll(){
        List<Role> roles = new ArrayList();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    public Role findById(Integer roleId){
        return roleRepository.findById(roleId).orElseThrow(() -> new DomainEntityNotFoundException(Role.class));
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }

    public void deleteById(Integer roleId){
        roleRepository.deleteById(roleId);
    }
}
