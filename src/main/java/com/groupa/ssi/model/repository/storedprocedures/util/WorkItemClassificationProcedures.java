package com.groupa.ssi.model.repository.storedprocedures.util;

/**
 * @author Miguel Rojas
 */
public class WorkItemClassificationProcedures implements GenericProcedureNames {

    public static final String ALL_NAME = "proGetAllWorkItemClassification";
    public static final String READ_NAME = "proGetWorkItemClassification";
    public static final String INSERT_NAME = "";
    public static final String UPDATE_NAME = "";
    public static final String DELETE_NAME = "";

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
