package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
@RequestMapping(value = PpeClassificationAbstractController.PATH)
public class PpeClassificationAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/ppeClassifications";

    public static final String TAG_NAME = "Ppe-classifications";

    public static final String DESCRIPTION = "Available operations over work classification of personal protection equipment";
}
