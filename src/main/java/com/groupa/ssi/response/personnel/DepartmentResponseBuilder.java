package com.groupa.ssi.response.personnel;


import com.groupa.ssi.model.domain.personnel.Department;

/**
 * @author Lizeth Salazar
 */

public class DepartmentResponseBuilder {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
