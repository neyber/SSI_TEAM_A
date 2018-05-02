package com.groupa.ssi.response.workitem;

import com.groupa.ssi.model.domain.workitem.ExistingWorkItem;

import java.util.Date;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
public final class ExistingWorkItemResponseBuilder {

    private Integer existingWorkItemId;
    private String detail;
    private Date purchaseDate;
    private String serieNo;
    private WorkItemResponse workItem;

    private ExistingWorkItemResponseBuilder() {
    }

    public ExistingWorkItemResponse build() {
        ExistingWorkItemResponse existingWorkItemResponse = new ExistingWorkItemResponse();
        existingWorkItemResponse.setExistingWorkItemId(existingWorkItemId);
        existingWorkItemResponse.setDetail(detail);
        existingWorkItemResponse.setPurchaseDate(purchaseDate);
        existingWorkItemResponse.setSerieNo(serieNo);
        existingWorkItemResponse.setWorkItem(workItem);

        return existingWorkItemResponse;
    }


    public static ExistingWorkItemResponseBuilder getInstance(ExistingWorkItem existingWorkItem) {
        ExistingWorkItemResponseBuilder existingWorkItemResponseBuilder =new ExistingWorkItemResponseBuilder();
        existingWorkItemResponseBuilder.setExistingWorkItemId(existingWorkItem.getId());
        existingWorkItemResponseBuilder.setDetail(existingWorkItem.getDetail());
        existingWorkItemResponseBuilder.setPurchaseDate(existingWorkItem.getPurchaseDate());
        existingWorkItemResponseBuilder.setSerieNo(existingWorkItem.getSerieNo());

        if(existingWorkItem.getWorkItem() != null){
            existingWorkItemResponseBuilder.setWorkItem(WorkItemResponseBuilder.getInstance(existingWorkItem.getWorkItem()).build());
        }

        return existingWorkItemResponseBuilder;
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

    public ExistingWorkItemResponseBuilder setSerieNo(String serieNo) {
        this.serieNo = serieNo;
        return this;
    }

    public ExistingWorkItemResponseBuilder setWorkItem(WorkItemResponse workItem) {
        this.workItem = workItem;
        return this;
    }
}
