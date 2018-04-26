package com.groupa.ssi.model.domain.catalog;

import com.groupa.ssi.model.domain.ModelBase;
import javax.persistence.*;

/**
 * This class is top represent the catalog for classification of personal protection equipment (Ppe)
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Entity
public class PpeClassification extends ModelBase {

    @Column
    private String name;

    @Column
    private String description;

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
