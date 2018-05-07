package com.groupa.ssi.response.workitem;

import java.util.Date;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
public class ExistingWorkItemResponse {

    private Integer existingWorkItemId;
    private String detail;
    private Date purchaseDate;
    private String serieNo;
    private WorkItemResponse workItem;

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

    public String getSerieNo() {
        return serieNo;
    }

    public void setSerieNo(String serieNo) {
        this.serieNo = serieNo;
    }

    public WorkItemResponse getWorkItem() {
        return workItem;
    }

    public void setWorkItem(WorkItemResponse workItem) {
        this.workItem = workItem;
    }
}
