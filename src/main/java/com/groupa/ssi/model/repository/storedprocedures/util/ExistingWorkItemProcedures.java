/**
 * @author: Miguel Rojas
 */
package com.groupa.ssi.model.repository.storedprocedures.util;

public class ExistingWorkItemProcedures implements GenericProcedureNames {

    public static final String ALL_NAME = "proGetAllExistingWorkItem";
    public static final String READ_NAME = "proGetExistingWorkItem";
    public static final String INSERT_NAME = "proInsertExistingWorkItem";
    public static final String UPDATE_NAME = "proUpdateExistingWorkItem";
    public static final String DELETE_NAME = "proDeleteExistingWorkItem";

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
