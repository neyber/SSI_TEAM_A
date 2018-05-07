package com.groupa.ssi.controller.workitem;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Miguel Rojas
 */
@RequestMapping(value = WorkItemAbstractController.PATH)
public abstract class WorkItemAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/workItems";

    public static final String TAG_NAME = "Work-items";

    public static final String DESCRIPTION = "Available operations over work items";
}
