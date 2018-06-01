package com.groupa.ssi.model.domain.catalog;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.repository.storedprocedures.util.WorkItemClassificationProcedures;

import javax.persistence.*;

/**
 * This class is top represent the catalog for classification of work item
 * Created on May 1, 2018
 *
 * @author Walker Colina
 */
@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = WorkItemClassificationProcedures.ALL_NAME,
                procedureName = WorkItemClassificationProcedures.ALL_NAME,
                resultClasses = WorkItemClassification.class
        ),
        @NamedStoredProcedureQuery(
                name = WorkItemClassificationProcedures.READ_NAME,
                procedureName = WorkItemClassificationProcedures.READ_NAME,
                resultClasses = WorkItemClassification.class,
                parameters = {
                        @StoredProcedureParameter(
                                name = "id",
                                mode = ParameterMode.IN,
                                type = Integer.class
                        )
                }
        ),
        @NamedStoredProcedureQuery(
                name = WorkItemClassificationProcedures.DELETE_NAME,
                procedureName = WorkItemClassificationProcedures.DELETE_NAME,
                parameters = {
                        @StoredProcedureParameter(
                                name = "id",
                                mode = ParameterMode.IN,
                                type = Integer.class
                        )
                }
        )
})
public class WorkItemClassification extends ModelBase {

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
