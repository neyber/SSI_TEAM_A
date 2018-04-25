package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lizeth Salazar
 */

@RequestMapping(value = RoleAbstractController.PATH)
public abstract class RoleAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/roles";

    public static final String TAG_NAME = "Roles";

    public static final String DESCRIPTION = "Available operations for Roles";
}
