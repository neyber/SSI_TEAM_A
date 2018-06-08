package com.groupa.ssi.controller.accidentReport;

import com.groupa.ssi.common.utils.Constants;
import com.groupa.ssi.controller.accident.AccidentAbstractController;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = AccidentReportAbstractController.PATH)
public class AccidentReportAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/accidentsReport";

    public static final String TAG_NAME = "accidentsReport";

    public static final String DESCRIPTION = "Available operations over accidents report";
}
