package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lizeth Salazar
 */

@RequestMapping(value = EmployeeAbstractController.PATH)
public class EmployeeAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/employees";

    public static final String TAG_NAME = "Employees";

    public static final String DESCRIPTION = "Available operations for Employees";
}
