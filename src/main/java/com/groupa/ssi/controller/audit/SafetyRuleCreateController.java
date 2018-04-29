package com.groupa.ssi.controller.audit;

import com.groupa.ssi.cmd.audit.SafetyRuleCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.audit.SafetyRuleRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Neyber Rojas Zapata
 */
@Api(
        tags = SafetyRuleAbstractController.TAG_NAME,
        description = SafetyRuleAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SafetyRuleCreateController extends SafetyRuleAbstractController {

    private SafetyRuleCreateCmd safetyRuleCreateCmd;

    public SafetyRuleCreateController(SafetyRuleCreateCmd safetyRuleCreateCmd) {
        this.safetyRuleCreateCmd = safetyRuleCreateCmd;
    }

    @ApiOperation(value = "Create safety rule")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createSafetyRule(@RequestBody SafetyRuleRequest safetyRuleRequest, @RequestParam(value = "userId", required = false) Integer userId) {
        safetyRuleCreateCmd.setSafetyRuleRequest(safetyRuleRequest);
        safetyRuleCreateCmd.execute();
        return new SuccessRestResponse();
    }
}
