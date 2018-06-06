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
public class RoleUpdateCmd extends AbstractCommand {

    @Autowired
    private RoleService roleService;

    private Integer roleId;
    private RoleRequest roleRequest;

    @Override
    protected void run() {
        Role role = composeRole(roleId, roleRequest);
        roleService.procedureUpdate(role);
    }

    private Role composeRole(Integer roleId, RoleRequest roleRequest) {
        Role role = roleService.procedureFindById(roleId);
        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());

        return role;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setRoleRequest(RoleRequest roleRequest) {
        this.roleRequest = roleRequest;
    }
}
