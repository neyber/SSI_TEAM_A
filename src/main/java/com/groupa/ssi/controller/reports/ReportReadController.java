package com.groupa.ssi.controller.reports;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.controller.catalog.WorkItemAbstractController;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.model.domain.report.Report;
import com.groupa.ssi.response.catalog.WorkItemResponse;
import com.groupa.ssi.response.catalog.WorkItemResponseBuilder;
import com.groupa.ssi.response.report.ReportResponse;
import com.groupa.ssi.response.report.ReportResponseBuilder;
import com.groupa.ssi.services.catalog.WorkItemService;
import com.groupa.ssi.services.report.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author : Linet Torrico
 */
@Api(
        tags = ReportAbstractController.TAG_NAME,
        description = ReportAbstractController.DESCRIPTION
)
@RestController
@RequestScope

public class ReportReadController  extends  ReportAbstractController{

    private ReportService service;

    public ReportReadController(ReportService service) {
        this.service = service;
    }

@ApiOperation( value = "Read reports")
@RequestMapping(
        value = "/{reportId}",
        method = RequestMethod.GET
)

    public SingleRestResponse<ReportResponse> readReport(@PathVariable Integer reportId){

    Report report = service.findById(reportId);
    return new SingleRestResponse(ReportResponseBuilder.getInstance(report).build());
}

}
