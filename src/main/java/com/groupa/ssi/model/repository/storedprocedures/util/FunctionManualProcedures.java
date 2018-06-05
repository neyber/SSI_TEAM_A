package com.groupa.ssi.model.repository.storedprocedures.util;

public class FunctionManualProcedures implements GenericProcedureNames {
    public static final String ALL_NAME = "proGetAllFunctionManuals";
    public static final String READ_NAME = "proGetFunctionManual";
    public static final String INSERT_NAME = "proInsertFunctionManual";
    public static final String UPDATE_NAME = "proUpdateFunctionManual";
    public static final String DELETE_NAME = "proDeleteFunctionManual";

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
