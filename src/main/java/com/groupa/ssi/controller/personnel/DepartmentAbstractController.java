package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lizeth Salazar
 */

@RequestMapping(value = DepartmentAbstractController.PATH)
public abstract class DepartmentAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/departments";

    public static final String TAG_NAME = "Departments";

    public static final String DESCRIPTION = "Available operations for Departments";
}
