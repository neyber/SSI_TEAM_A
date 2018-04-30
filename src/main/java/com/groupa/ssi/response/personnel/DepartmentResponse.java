package com.groupa.ssi.response.personnel;

/**
 * @author Lizeth Salazar
 */

public class DepartmentResponse {
    private Integer departmentId;
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
