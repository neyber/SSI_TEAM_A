package com.groupa.ssi.response.personalprotectionequipment;

import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;

import java.util.Date;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
public final class ExistingPpeResponseBuilder {

    private Integer existingPpeId;
    private String detail;
    private Date purchaseDate;
    private int lifeTimeDays;
    private int currentLifeTimeDays;
    private PpeResponse ppe;

    private ExistingPpeResponseBuilder() {
    }

    public ExistingPpeResponse build() {
        ExistingPpeResponse existingPpeResponse = new ExistingPpeResponse();
        existingPpeResponse.setExistingPpeId(existingPpeId);
        existingPpeResponse.setDetail(detail);
        existingPpeResponse.setPurchaseDate(purchaseDate);
        existingPpeResponse.setLifeTimeDays(lifeTimeDays);
        existingPpeResponse.setCurrentLifeTimeDays(currentLifeTimeDays);
        existingPpeResponse.setPpe(ppe);

        return existingPpeResponse;
    }


    public static ExistingPpeResponseBuilder getInstance(ExistingPpe existingPpe) {
        ExistingPpeResponseBuilder existingPpeResponseBuilder = new ExistingPpeResponseBuilder();
        existingPpeResponseBuilder.setExistingPpeId(existingPpe.getId());
        existingPpeResponseBuilder.setDetail(existingPpe.getDetail());
        existingPpeResponseBuilder.setPurchaseDate(existingPpe.getPurchaseDate());
        existingPpeResponseBuilder.setLifeTimeDays(existingPpe.getLifeTimeDays());
        existingPpeResponseBuilder.setCurrentLifeTimeDays(existingPpe.getCurrentLifeTimeDays());
        if(existingPpe.getPpe() != null) {
            existingPpeResponseBuilder.setPpe(PpeResponseBuilder.getInstance(existingPpe.getPpe()).build());
        }

        return existingPpeResponseBuilder;
    }

    public ExistingPpeResponseBuilder setExistingPpeId(Integer existingPpeId) {
        this.existingPpeId = existingPpeId;
        return this;
    }

    public ExistingPpeResponseBuilder setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public ExistingPpeResponseBuilder setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public ExistingPpeResponseBuilder setLifeTimeDays(int lifeTimeDays) {
        this.lifeTimeDays = lifeTimeDays;
        return this;
    }

    public ExistingPpeResponseBuilder setCurrentLifeTimeDays(int currentLifeTimeDays) {
        this.currentLifeTimeDays = currentLifeTimeDays;
        return this;
    }

    public ExistingPpeResponseBuilder setPpe(PpeResponse ppe) {
        this.ppe = ppe;
        return this;
    }
}
