package com.groupa.ssi.controller.auditHistory;

import com.groupa.ssi.cmd.auditHistory.AuditHistoryListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.auditHistory.AuditHistoryResponse;
import com.groupa.ssi.response.auditHistory.AuditHistoryResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lizeth Salazar
 */

@Api(tags = AuditHistoryAbstractController.TAG_NAME, description = AuditHistoryAbstractController.DESCRIPTION)
@RestController
@RequestScope

public class AuditHistoryListController {

    @Autowired
    private AuditHistoryListCmd auditHistoryListCmd;

    @ApiOperation(value = "List Audit History")
    @RequestMapping(method = RequestMethod.GET)
    public ListRestResponse<AuditHistoryResponse> getAuditHistoryList(@RequestParam(value="userId", required = false) Integer userId){

        auditHistoryListCmd.execute();
        List<AuditHistoryResponse> auditHistoryList = auditHistoryListCmd.getAuditHistorySSIList().stream()
                .map(instance -> AuditHistoryResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(auditHistoryList);
    }
}
