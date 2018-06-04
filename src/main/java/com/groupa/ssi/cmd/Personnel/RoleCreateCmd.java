package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.request.personnel.RoleRequest;
import com.groupa.ssi.services.personnel.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class RoleCreateCmd extends AbstractCommand {
    private RoleRequest roleRequest;

    @Autowired
    private RoleService roleService;

    @Override
    protected void run() {
        Role role = ComposeRole(roleRequest);
        roleService.procedureCreate(role);
    }

    private Role ComposeRole(RoleRequest roleRequest) {
        Role role = new Role();
        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());
        return role;
    }

    public void setRoleRequest(RoleRequest roleRequest) {
        this.roleRequest = roleRequest;
    }
}
