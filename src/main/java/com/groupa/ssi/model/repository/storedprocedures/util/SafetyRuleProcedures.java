package com.groupa.ssi.model.repository.storedprocedures.util;

public class SafetyRuleProcedures implements GenericProcedureNames {
    public static final String ALL_NAME = "proGetAllSafetyRules";
    public static final String READ_NAME = "proGetSafetyRule";
    public static final String INSERT_NAME = "proInsertSafetyRule";
    public static final String UPDATE_NAME = "proUpdateSafetyRule";
    public static final String DELETE_NAME = "proDeleteSafetyRule";

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
