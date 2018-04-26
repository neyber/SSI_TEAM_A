/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.accident;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = AccidentAbstractController.PATH)
public class AccidentAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/accidents";

    public static final String TAG_NAME = "accidents";

    public static final String DESCRIPTION = "Available operations over accidents";
}
