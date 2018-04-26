package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neyber Rojas Zapata
 */
@RequestMapping(value = AuditInternalAbstractController.PATH)
public abstract class AuditInternalAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/auditInternals";

    public static final String TAG_NAME = "AuditInternals";

    public static final String DESCRIPTION = "Available operations for Audit Internals";
}
