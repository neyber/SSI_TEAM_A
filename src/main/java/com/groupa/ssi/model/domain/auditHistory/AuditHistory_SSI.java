package com.groupa.ssi.model.domain.auditHistory;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Lizeth Salazar
 */

@Entity
public class AuditHistory_SSI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idAuditHistory;
    @Column
    private String tableName;
    @Column
    private String columnName;
    @Column
    private int idFeature;
    @Column
    private String oldValue;
    @Column
    private String newValue;
    @Column
    private Date createdDate;
    @Column
    private int createdBy;
    @Column
    private Date modifiedDate;
    @Column
    private int modifiedBy;

    public int getIdAuditHistory() {
        return idAuditHistory;
    }

    public void setIdAuditHistory(int idAuditHistory) {
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

    public int getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(int idFeature) {
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

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
