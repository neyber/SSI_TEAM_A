package com.groupa.ssi.request.catalog;

/*
Created on 28/4/18
@author: HENRYBC
*/
public class SaClassificationRequest {

    private String category;

    private Integer totalDaysOutOfWork;

    private Integer totalDaysRestrictedTransferredWork;

    private String type;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getTotalDaysOutOfWork() {
        return totalDaysOutOfWork;
    }

    public void setTotalDaysOutOfWork(Integer totalDaysOutOfWork) {
        this.totalDaysOutOfWork = totalDaysOutOfWork;
    }

    public Integer getTotalDaysRestrictedTransferredWork() {
        return totalDaysRestrictedTransferredWork;
    }

    public void setTotalDaysRestrictedTransferredWork(Integer totalDaysRestrictedTransferredWork) {
        this.totalDaysRestrictedTransferredWork = totalDaysRestrictedTransferredWork;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
