package com.groupa.ssi.model.repository.storedprocedures.util;

public class AuditProcedures implements GenericProcedureNames{
    public static final String ALL_NAME = "proGetAllAudits";
    public static final String READ_NAME = "proGetAudit";
    public static final String INSERT_NAME = "proInsertAudit";
    public static final String UPDATE_NAME = "proUpdateAudit";
    public static final String DELETE_NAME = "proDeleteAudit";

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
