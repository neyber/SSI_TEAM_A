package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
@RequestMapping(value = PpeAbstractController.PATH)
public abstract class PpeAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/ppes";

    public static final String TAG_NAME = "Ppes";

    public static final String DESCRIPTION = "Available operations over work of personal protection equipment";
}
