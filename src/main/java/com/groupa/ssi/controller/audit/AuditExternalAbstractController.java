package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neyber Rojas Zapata
 */
@RequestMapping(value = AuditExternalAbstractController.PATH)
public abstract class AuditExternalAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/auditExternals";

    public static final String TAG_NAME = "AuditExternals";

    public static final String DESCRIPTION = "Available operations for Audit Externals";
}
