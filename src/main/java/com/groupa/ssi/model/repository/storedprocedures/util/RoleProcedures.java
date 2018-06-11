package com.groupa.ssi.model.repository.storedprocedures.util;

public class RoleProcedures implements GenericProcedureNames {
    public static final String ALL_NAME = "proGetAllRoles";
    public static final String READ_NAME = "proGetRole";
    public static final String INSERT_NAME = "proInsertRole";
    public static final String UPDATE_NAME = "proUpdateRole";
    public static final String DELETE_NAME = "proDeleteRole";

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
