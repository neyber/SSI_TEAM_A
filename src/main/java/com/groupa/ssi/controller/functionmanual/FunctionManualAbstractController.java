package com.groupa.ssi.controller.usermanual;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Marcelo Loayza
 */

@RequestMapping(value = UserManualAbstractController.PATH)
public abstract class UserManualAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/userManuals";

    public static final String TAG_NAME = "UserManuals";

    public static final String DESCRIPTION = "Available operations for UserManuals";
}
