package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neyber Rojas Zapata
 */
@RequestMapping(value = SafetyRuleAbstractController.PATH)
public abstract class SafetyRuleAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/safetyRules";
    public static final String TAG_NAME = "SafetyRules";
    public static final String DESCRIPTION = "Available operations for safety rules";
}
