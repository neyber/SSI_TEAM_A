package com.groupa.ssi.controller.auditHistory;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lizeth Salazar
 */

@RequestMapping(value = AuditHistoryAbstractController.PATH)
public class AuditHistoryAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/auditHistory";

    public static final String TAG_NAME = "Audit History";

    public static final String DESCRIPTION = "Available operations for Audit History";
}
