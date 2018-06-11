package com.groupa.ssi.model.repository.storedprocedures.util;

/**
 * @author Miguel Rojas
 */
public class EmployeeProcedures implements GenericProcedureNames {

    public static final String ALL_NAME = "proGetAllEmployees";
    public static final String READ_NAME = "proGetEmployee";
    public static final String INSERT_NAME = "proInsertEmployee";
    public static final String UPDATE_NAME = "proUpdateEmployee";
    public static final String DELETE_NAME = "proDeleteEmployee";

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
