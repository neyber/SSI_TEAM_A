package com.groupa.ssi.controller.accidentReport;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.controller.accident.AccidentAbstractController;
import com.groupa.ssi.modeldw.domain.accident.AccidentReport;
import com.groupa.ssi.response.accident.AccidentResponse;
import com.groupa.ssi.response.accident.AccidentResponseBuilder;
import com.groupa.ssi.services.accidentReport.AccidentReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Api(
        tags = AccidentReportAbstractController.TAG_NAME,
        description = AccidentReportAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class AccidentReportController extends AccidentReportAbstractController{
    @Autowired
    private AccidentReportService service;

    @ApiOperation(value = "Report of accidents by date range")
    @RequestMapping(
            method = RequestMethod.GET
    )

    public List<AccidentReport> getAccidentReport(@RequestParam(value = "startDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate
                                                                        , @RequestParam(value = "endDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) throws SQLException, ClassNotFoundException {

        return (List<AccidentReport>) service.findAll(startDate, endDate);
    }
}
