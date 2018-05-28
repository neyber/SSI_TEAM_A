package com.groupa.ssi.model.domain.personalprotectionequipment;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.catalog.PpeClassification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * This class is top represent the existing (inventory) personal protection equipment (Ppe)
 * Created on April 26, 2018
 * @author Walker Colina
 */
@Entity
public class ExistingPpe extends ModelBase {

    @Column
    private String detail;

    @Column
    private Date purchaseDate;

    @Column
    private int lifeTimeDays;

    @Column
    private int currentLifeTimeDays;

    @ManyToOne
    @JoinColumn(name = "ppeId")
    private Ppe ppe;

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

    public Ppe getPpe() {
        return ppe;
    }

    public void setPpe(Ppe ppe) {
        this.ppe = ppe;
    }

}
