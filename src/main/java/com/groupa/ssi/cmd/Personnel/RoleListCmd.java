package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.services.personnel.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class RoleListCmd extends AbstractCommand {

    @Autowired
    private RoleService roleService;

    private List<Role> rolesList;

    @Override
    protected void run() {
        rolesList = roleService.findAll();
    }

    public List<Role> getRolesList() {
        return rolesList;
    }
}
