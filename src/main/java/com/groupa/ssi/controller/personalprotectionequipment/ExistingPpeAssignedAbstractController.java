package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@RequestMapping(value = ExistingPpeAssignedAbstractController.PATH)
public abstract class ExistingPpeAssignedAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/existingPpeAssigneds";

    public static final String TAG_NAME = "existing-Ppe-Assigneds";

    public static final String DESCRIPTION = "Available operations over work of existing personal protection equipment assigned";
}
