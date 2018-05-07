package com.groupa.ssi.request.workitem;

import java.util.Date;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
public class ExistingWorkItemRequest {

    private String detail;
    private Date purchaseDate;
    private String serieNo;
    private Integer workItemId;

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

    public Integer getWorkItemId() {
        return workItemId;
    }

    public void setWorkItemId(Integer workItemId) {
        this.workItemId = workItemId;
    }
}
