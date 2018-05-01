package com.groupa.ssi.response.workitem;

import com.groupa.ssi.model.domain.workitem.WorkItem;

import java.util.Date;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
public class ExistingWorkItemResponse {

    private Integer existingWorkItemId;
    private String detail;
    private Date purchaseDate;
    private WorkItem workItem;

    public Integer getExistingWorkItemId() {
        return existingWorkItemId;
    }

    public void setExistingWorkItemId(Integer existingWorkItemId) {
        this.existingWorkItemId = existingWorkItemId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public WorkItem getWorkItem() {
        return workItem;
    }

    public void setWorkItem(WorkItem workItem) {
        this.workItem = workItem;
    }
}
