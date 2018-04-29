package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.personnel.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class RoleDeleteCmd extends AbstractCommand {
    private Integer roleId;

    @Autowired
    private RoleService roleService;

    @Override
    protected void run() {
        roleService.deleteById(roleId);
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
