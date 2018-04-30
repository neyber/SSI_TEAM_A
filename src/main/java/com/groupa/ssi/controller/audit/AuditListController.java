package com.groupa.ssi.controller.audit;

import com.groupa.ssi.cmd.audit.AuditListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.audit.AuditResponse;
import com.groupa.ssi.response.audit.AuditResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

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

    private AuditListCmd auditListCmd;

    public AuditListController(AuditListCmd auditListCmd) {
        this.auditListCmd = auditListCmd;
    }

    @ApiOperation(value = "List of audits")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<AuditResponse> getAuditList(@RequestParam(value = "userId", required = false) Integer userId) {
        auditListCmd.execute();

        List<AuditResponse> auditResponses = auditListCmd.getAuditList().stream()
                .map(instance -> AuditResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(auditResponses);
    }
}
