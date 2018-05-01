package com.groupa.ssi.model.domain.workitem;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Miguel Rojas
 * @Modified : Linet Torrico
 */
@Entity
public class WorkItem {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workItemId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String type;

    @Column
    private String status;

    @Column
    private Date  purchaseDate;

    @Column
    private String serieNo;


    public String getSerieNo() {
        return serieNo;
    }

    public void setSerieNo(String serieNo) {
        this.serieNo = serieNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getWorkItemId() {
        return workItemId;
    }

    public void setWorkItemId(Integer workItemId) {
        this.workItemId = workItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
