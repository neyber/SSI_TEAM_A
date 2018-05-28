package com.groupa.ssi.model.domain.report;


import javax.persistence.*;
import java.util.Date;

/**
 * @author Miguel Rojas
 * @Modified : Linet Torrico
 */
public class Report {

    private Integer ReportId;

    private String name;

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
