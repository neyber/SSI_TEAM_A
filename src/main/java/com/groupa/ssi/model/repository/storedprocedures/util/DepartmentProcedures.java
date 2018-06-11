package com.groupa.ssi.model.repository.storedprocedures.util;

public class DepartmentProcedures implements GenericProcedureNames  {
    public static final String ALL_NAME = "proGetAllDepartments";
    public static final String READ_NAME = "proGetDepartment";
    public static final String INSERT_NAME = "proInsertDepartment";
    public static final String UPDATE_NAME = "proUpdateDepartment";
    public static final String DELETE_NAME = "proDeleteDepartment";

    public String allProcedureName() {
        return ALL_NAME;
    }

    public String readProcedureName() {
        return READ_NAME;
    }

    public String insertProcedureName() {
        return INSERT_NAME;
    }

    public String updateProcedureName() {
        return UPDATE_NAME;
    }

    public String deleteProcedureName() {
        return DELETE_NAME;
    }
}
