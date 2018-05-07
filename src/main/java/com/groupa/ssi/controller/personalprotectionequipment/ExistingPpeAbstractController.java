package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
@RequestMapping(value = ExistingPpeAbstractController.PATH)
public abstract class ExistingPpeAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/existingPpes";

    public static final String TAG_NAME = "existing-Ppes";

    public static final String DESCRIPTION = "Available operations over work of existing personal protection equipment";
}
