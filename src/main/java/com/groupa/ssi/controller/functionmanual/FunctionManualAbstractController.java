package com.groupa.ssi.controller.functionmanual;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Marcelo Loayza
 */

@RequestMapping(value = FunctionManualAbstractController.PATH)
public abstract class FunctionManualAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/functionManuals";

    public static final String TAG_NAME = "FunctionManuals";

    public static final String DESCRIPTION = "Available operations for FunctionManuals";
}
