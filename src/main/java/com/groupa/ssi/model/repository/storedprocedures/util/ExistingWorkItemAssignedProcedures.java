package com.groupa.ssi.model.repository.storedprocedures.util;

/**
 * @author Miguel Rojas
 */
public class ExistingWorkItemAssignedProcedures implements GenericProcedureNames {

    public static final String ALL_NAME = "proGetAllExistingWorkItemAssigneds";
    public static final String READ_NAME = "proGetExistingWorkItemAssigned";
    public static final String INSERT_NAME = "proInsertExistingWorkItemAssigned";
    public static final String UPDATE_NAME = "proUpdateExistingWorkItemAssigned";
    public static final String DELETE_NAME = "proDeleteExistingWorkItemAssigned";

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
