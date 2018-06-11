package com.groupa.ssi.model.repository.storedprocedures.util;

/**
 * @author Miguel Rojas
 */
public class WorkItemProcedures implements GenericProcedureNames {

    public static final String ALL_NAME = "proGetAllWorkItem";
    public static final String READ_NAME = "proGetWorkItem";
    public static final String INSERT_NAME = "proInsertWorkItem";
    public static final String UPDATE_NAME = "proUpdateWorkItem";
    public static final String DELETE_NAME = "proDeleteWorkItem";

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
