package com.groupa.ssi.response.report;

import com.groupa.ssi.model.domain.report.Report;


public class ReportResponseBuilder {

    private Integer reportId;
    private String name;
    private String description;

    private ReportResponseBuilder() {
    }

    public ReportResponse build() {
        ReportResponse reportResponse= new ReportResponse();
        reportResponse.setReportId(reportId);
        reportResponse.setName(name);
        reportResponse.setDescription(description);


        return reportResponse;
    }

    public static ReportResponseBuilder getInstance(Report report) {
        return new ReportResponseBuilder()
                .setReportId(report.getReportId())
                .setName(report.getName())
                .setDescription(report.getDescription());

    }

    public ReportResponseBuilder setReportId(Integer reportId) {
        this.reportId = reportId;
        return this;
    }

    public ReportResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ReportResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

}
