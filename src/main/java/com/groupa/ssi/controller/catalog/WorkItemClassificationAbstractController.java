package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@RequestMapping(value = WorkItemClassificationAbstractController.PATH)
public abstract class WorkItemClassificationAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/workItemClassifications";

    public static final String TAG_NAME = "Work-item-classifications";

    public static final String DESCRIPTION = "Available operations over work in the work item classification";
}
