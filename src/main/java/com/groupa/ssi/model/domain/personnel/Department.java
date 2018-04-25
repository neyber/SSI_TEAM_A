package com.groupa.ssi.model.domain.personnel;

import com.groupa.ssi.model.domain.ModelBase;

import javax.persistence.*;

/**
 * @author Lizeth Salazar
 */

@Entity
public class Department extends ModelBase {

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
