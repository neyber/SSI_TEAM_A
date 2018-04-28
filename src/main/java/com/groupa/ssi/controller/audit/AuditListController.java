package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.response.audit.AuditResponse;
import com.groupa.ssi.services.audit.AuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * @author Neyber Rojas Zapata
 */
@Api(
        tags = AuditAbstractController.TAG_NAME,
        description = AuditAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class AuditListController extends AuditAbstractController {

    private AuditService auditService;

    public AuditListController(AuditService auditService) {
        this.auditService = auditService;
    }

    @ApiOperation(value = "List of audits")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<AuditResponse> getAuditList(@RequestParam(value = "userId") Integer userId) {
        List<Audit> auditList = auditService.findAll();

        return new ListRestResponse(auditList);
    }
}
