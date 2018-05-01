package com.groupa.ssi.response.workitem;

import com.groupa.ssi.model.domain.workitem.ExistingWorkItem;
import com.groupa.ssi.model.domain.workitem.WorkItem;

import java.util.Date;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
public final class ExistingWorkItemResponseBuilder {

    private Integer existingWorkItemId;
    private String detail;
    private Date purchaseDate;
    private WorkItem workItem;

    private ExistingWorkItemResponseBuilder() {
    }

    public ExistingWorkItemResponse build() {
        ExistingWorkItemResponse existingWorkItemResponse = new ExistingWorkItemResponse();
        existingWorkItemResponse.setExistingWorkItemId(existingWorkItemId);
        existingWorkItemResponse.setDetail(detail);
        existingWorkItemResponse.setPurchaseDate(purchaseDate);
        existingWorkItemResponse.setWorkItem(workItem);

        return existingWorkItemResponse;
    }


    public static ExistingWorkItemResponseBuilder getInstance(ExistingWorkItem existingWorkItem) {
        return new ExistingWorkItemResponseBuilder()
                .setExistingWorkItemId(existingWorkItem.getId())
                .setDetail(existingWorkItem.getDetail())
                .setPurchaseDate(existingWorkItem.getPurchaseDate())
                .setWorkItem(existingWorkItem.getWorkItem());
    }

    public ExistingWorkItemResponseBuilder setExistingWorkItemId(Integer existingWorkItemId) {
        this.existingWorkItemId = existingWorkItemId;
        return this;
    }

    public ExistingWorkItemResponseBuilder setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public ExistingWorkItemResponseBuilder setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public ExistingWorkItemResponseBuilder setWorkItem(WorkItem workItem) {
        this.workItem = workItem;
        return this;
    }
}
