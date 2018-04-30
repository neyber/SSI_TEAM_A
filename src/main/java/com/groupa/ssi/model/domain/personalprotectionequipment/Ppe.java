package com.groupa.ssi.model.domain.personalprotectionequipment;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.catalog.PpeClassification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * This class is top represent the catalog for personal protection equipment (Ppe)
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Entity
public class Ppe extends ModelBase {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Byte[] image;

    @ManyToOne
    private PpeClassification ppeClassification;

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

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public PpeClassification getPpeClassification() {
        return ppeClassification;
    }

    public void setPpeClassification(PpeClassification ppeClassification) {
        this.ppeClassification = ppeClassification;
    }
}
