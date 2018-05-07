package com.groupa.ssi.controller.reports;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Linet Torrico
 */
@RequestMapping(value = ReportAbstractController.PATH)
public abstract class ReportAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/reports";

    public static final String TAG_NAME = "Reports";

    public static final String DESCRIPTION = "Available operations over System reports";
}
