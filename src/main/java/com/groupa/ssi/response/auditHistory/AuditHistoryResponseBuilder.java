package com.groupa.ssi.response.auditHistory;

import com.groupa.ssi.model.domain.auditHistory.AuditHistory_SSI;

import java.util.Date;

/**
 * @author Lizeth Salazar
 */

public class AuditHistoryResponseBuilder {

    private Integer idAuditHistory;
    private String tableName;
    private String columnName;
    private Integer idFeature;
    private String oldValue;
    private String newValue;
    private Date createdDate;
    private Integer createdBy;
    private Date modifiedDate;
    private Integer modifiedBy;

    public AuditHistoryResponseBuilder() {
    }

    public AuditHistoryResponse build() {
        AuditHistoryResponse auditHistoryResponse = new AuditHistoryResponse();
        auditHistoryResponse.setIdAuditHistory(idAuditHistory);
        auditHistoryResponse.setTableName(tableName);
        auditHistoryResponse.setColumnName(columnName);
        auditHistoryResponse.setIdFeature(idFeature);
        auditHistoryResponse.setOldValue(oldValue);
        auditHistoryResponse.setNewValue(newValue);
        auditHistoryResponse.setCreatedDate(createdDate);
        auditHistoryResponse.setCreatedBy(createdBy);
        auditHistoryResponse.setModifiedDate(modifiedDate);
        auditHistoryResponse.setModifiedBy(modifiedBy);
        return auditHistoryResponse;
    }

    public static AuditHistoryResponseBuilder getInstance(AuditHistory_SSI auditHistorySSI){
        AuditHistoryResponseBuilder auditHistoryResponseBuilder = new AuditHistoryResponseBuilder();
        auditHistoryResponseBuilder.setIdAuditHistory(auditHistorySSI.getIdAuditHistory());
        auditHistoryResponseBuilder.setTableName(auditHistorySSI.getTableName());
        auditHistoryResponseBuilder.setColumnName(auditHistorySSI.getTableName());
        auditHistoryResponseBuilder.setIdFeature(auditHistorySSI.getIdFeature());
        auditHistoryResponseBuilder.setOldValue(auditHistorySSI.getOldValue());
        auditHistoryResponseBuilder.setNewValue(auditHistorySSI.getNewValue());
        auditHistoryResponseBuilder.setCreatedDate(auditHistorySSI.getCreatedDate());
        auditHistoryResponseBuilder.setCreatedBy(auditHistorySSI.getCreatedBy());
        auditHistoryResponseBuilder.setModifiedDate(auditHistorySSI.getModifiedDate());
        auditHistoryResponseBuilder.setModifiedBy(auditHistorySSI.getModifiedBy());
        return auditHistoryResponseBuilder;
    }

    public AuditHistoryResponseBuilder setIdAuditHistory(Integer idAuditHistory) {
        this.idAuditHistory = idAuditHistory;
        return this;
    }

    public AuditHistoryResponseBuilder setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public AuditHistoryResponseBuilder setColumnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    public AuditHistoryResponseBuilder setIdFeature(Integer idFeature) {
        this.idFeature = idFeature;
        return this;
    }

    public AuditHistoryResponseBuilder setOldValue(String oldValue) {
        this.oldValue = oldValue;
        return this;
    }

    public AuditHistoryResponseBuilder setNewValue(String newValue) {
        this.newValue = newValue;
        return this;
    }

    public AuditHistoryResponseBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public AuditHistoryResponseBuilder setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public AuditHistoryResponseBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public AuditHistoryResponseBuilder setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }
}
