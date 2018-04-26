/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = SicknessAbstractController.PATH)
public class SicknessAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/diseases";

    public static final String TAG_NAME = "diseases";

    public static final String DESCRIPTION = "Available operations over diseases";
}
