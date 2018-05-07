package com.groupa.ssi.response.personnel;

import com.groupa.ssi.model.domain.personnel.Role;

/**
 * @author Lizeth Salazar
 */

public final class RoleResponseBuilder {
    private Integer roleId;
    private String name;
    private String description;

    private RoleResponseBuilder(){}

    public RoleResponse build(){
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setRoleId(roleId);
        roleResponse.setName(name);
        roleResponse.setDescription(description);
        return roleResponse;
    }

    public static RoleResponseBuilder getInstance(Role role){
        RoleResponseBuilder roleResponseBuilder = new RoleResponseBuilder();
        roleResponseBuilder.setRoleId(role.getId());
        roleResponseBuilder.setName(role.getName());
        roleResponseBuilder.setDescription(role.getDescription());
        return roleResponseBuilder;

    }

    public RoleResponseBuilder setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public RoleResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RoleResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
}
