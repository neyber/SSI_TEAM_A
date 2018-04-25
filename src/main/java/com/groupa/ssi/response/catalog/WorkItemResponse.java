package com.groupa.ssi.response.catalog;

import java.util.Date;

/**
 * @author Miguel Rojas
 * @Modified by Linet Torrico
 */
public class WorkItemResponse {

    private String name;
    private String description;

    private String type;
    private String status;
    private Date purchaseDate;
    private Integer serieNo;

    public Integer getSerieNo() {
        return serieNo;
    }

    public void setSerieNo(Integer serieNo) {
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
