package com.groupa.ssi.response.personnel;


import com.groupa.ssi.model.domain.personnel.Department;

/**
 * @author Lizeth Salazar
 */

public final class DepartmentResponseBuilder {
    private String name;
    private String description;

    private DepartmentResponseBuilder() {
    }

    public DepartmentResponse build() {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setName(name);
        departmentResponse.setDescription(description);
        return departmentResponse;
    }

    public static DepartmentResponseBuilder getInstance(Department department){
        DepartmentResponseBuilder departmentResponseBuilder = new DepartmentResponseBuilder();
        departmentResponseBuilder.setName(department.getName());
        departmentResponseBuilder.setDescription(department.getDescription());
        return departmentResponseBuilder;
    }

    public DepartmentResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DepartmentResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
}
