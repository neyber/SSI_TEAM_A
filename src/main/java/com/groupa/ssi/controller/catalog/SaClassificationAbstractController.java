package com.groupa.ssi.controller.catalog;

/*
Created on 28/4/18
@author: HENRYBC
*/

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = SaClassificationAbstractController.PATH)
public class SaClassificationAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/saClassifications";

    public static final String TAG_NAME = "sa-classifications";

    public static final String DESCRIPTION = "Available operations over work classification of sickness and accidents";
}
