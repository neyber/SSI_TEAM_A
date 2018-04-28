package com.groupa.ssi.response.personnel;

import com.groupa.ssi.model.domain.personnel.Role;

/**
 * @author Lizeth Salazar
 */

public final class RoleResponseBuilder {
    private String name;
    private String description;

    private RoleResponseBuilder(){}

    public RoleResponse build(){
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setName(name);
        roleResponse.setDescription(description);
        return roleResponse;
    }

    public static RoleResponseBuilder getInstance(Role role){
        RoleResponseBuilder roleResponseBuilder = new RoleResponseBuilder();
        roleResponseBuilder.setName(role.getName());
        roleResponseBuilder.setDescription(role.getDescription());
        return roleResponseBuilder;

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
