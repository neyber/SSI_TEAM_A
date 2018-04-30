package com.groupa.ssi.request.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;

import java.util.Date;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
public class ExistingPpeRequest {

    private String detail;
    private Date purchaseDate;
    private int lifeTimeDays;
    private int currentLifeTimeDays;
    private Integer ppeId;

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

    public int getLifeTimeDays() {
        return lifeTimeDays;
    }

    public void setLifeTimeDays(int lifeTimeDays) {
        this.lifeTimeDays = lifeTimeDays;
    }

    public int getCurrentLifeTimeDays() {
        return currentLifeTimeDays;
    }

    public void setCurrentLifeTimeDays(int currentLifeTimeDays) {
        this.currentLifeTimeDays = currentLifeTimeDays;
    }

    public Integer getPpeId() {
        return ppeId;
    }

    public void setPpeId(Integer ppeId) {
        this.ppeId = ppeId;
    }
}
