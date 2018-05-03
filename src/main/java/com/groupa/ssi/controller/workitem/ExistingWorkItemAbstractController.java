package com.groupa.ssi.controller.workitem;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@RequestMapping(value = ExistingWorkItemAbstractController.PATH)
public abstract class ExistingWorkItemAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/existingWorkItems";

    public static final String TAG_NAME = "existing-Work-Items";

    public static final String DESCRIPTION = "Available operations over work of existing work items";
}
