package com.groupa.ssi.controller.saclassification;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/*
Created on 13/5/18
@author: HENRYBC
*/
@RequestMapping(value = SaTypeAbstractController.PATH)
public class SaTypeAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/saTypes";

    public static final String TAG_NAME = "saTypes";

    public static final String DESCRIPTION = "Available operations over saTypes";
}
