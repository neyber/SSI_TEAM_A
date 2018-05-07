package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neyber Rojas Zapata
 */
@RequestMapping(value = AuditAbstractController.PATH)
public abstract class AuditAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/audits";
    public static final String TAG_NAME = "Audits";
    public static final String DESCRIPTION = "Available operations for audits";
}
