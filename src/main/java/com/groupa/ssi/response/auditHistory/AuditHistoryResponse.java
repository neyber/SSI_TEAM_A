package com.groupa.ssi.response.auditHistory;

import java.util.Date;

/**
 * @author Lizeth Salazar
 */

public class AuditHistoryResponse {

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

    public Integer getIdAuditHistory() {
        return idAuditHistory;
    }

    public void setIdAuditHistory(Integer idAuditHistory) {
        this.idAuditHistory = idAuditHistory;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(Integer idFeature) {
        this.idFeature = idFeature;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
