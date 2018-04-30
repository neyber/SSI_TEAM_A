package com.groupa.ssi.response.personnel;


import com.groupa.ssi.model.domain.personnel.Department;

/**
 * @author Lizeth Salazar
 */

public final class DepartmentResponseBuilder {
    private Integer departmentId;
    private String name;
    private String description;

    private DepartmentResponseBuilder() {
    }

    public DepartmentResponse build() {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setDepartmentId(departmentId);
        departmentResponse.setName(name);
        departmentResponse.setDescription(description);
        return departmentResponse;
    }

    public static DepartmentResponseBuilder getInstance(Department department){
        DepartmentResponseBuilder departmentResponseBuilder = new DepartmentResponseBuilder();
        departmentResponseBuilder.setDepartmentId(department.getId());
        departmentResponseBuilder.setName(department.getName());
        departmentResponseBuilder.setDescription(department.getDescription());
        return departmentResponseBuilder;
    }

    public DepartmentResponseBuilder setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
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
