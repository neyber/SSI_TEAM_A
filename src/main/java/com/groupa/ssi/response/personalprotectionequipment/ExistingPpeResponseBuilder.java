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
    private Ppe ppe;

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


    public static ExistingPpeResponseBuilder getInstance(ExistingPpe existinPpe) {
        return new ExistingPpeResponseBuilder()
                .setExistingPpeId(existinPpe.getId())
                .setDetail(existinPpe.getDetail())
                .setPurchaseDate(existinPpe.getPurchaseDate())
                .setLifeTimeDays(existinPpe.getLifeTimeDays())
                .setCurrentLifeTimeDays(existinPpe.getCurrentLifeTimeDays())
                .setPpe(existinPpe.getPpe());
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

    public ExistingPpeResponseBuilder setPpe(Ppe ppe) {
        this.ppe = ppe;
        return this;
    }
}
