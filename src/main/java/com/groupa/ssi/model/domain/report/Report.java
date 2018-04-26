package com.groupa.ssi.model.domain.report;


import javax.persistence.*;
import java.util.Date;

/**
 * @author Miguel Rojas
 * @Modified : Linet Torrico
 */
@Entity
public class Report {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ReportId;

    @Column
    private String name;

    @Column
    private String description;

    public Integer getReportId() {
        return ReportId;
    }

    public void setReportId(Integer reportId) {
        ReportId = reportId;
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
