package com.groupa.ssi.controller.audit;

import com.groupa.ssi.cmd.audit.SafetyRuleUpdateCmd;
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
public class SafetyRuleUpdateController extends SafetyRuleAbstractController {

    private SafetyRuleUpdateCmd safetyRuleUpdateCmd;

    public SafetyRuleUpdateController(SafetyRuleUpdateCmd safetyRuleUpdateCmd) {
        this.safetyRuleUpdateCmd = safetyRuleUpdateCmd;
    }

    @ApiOperation(value = "Update safety rule")
    @RequestMapping(
            value = "/{safetyRuleId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateSafetyRule(@PathVariable Integer safetyRuleId, @RequestBody SafetyRuleRequest safetyRuleRequest, @RequestParam(value = "userId") Integer userId) {
        safetyRuleUpdateCmd.setSafetyRuleId(safetyRuleId);
        safetyRuleUpdateCmd.setSafetyRuleRequest(safetyRuleRequest);
        safetyRuleUpdateCmd.execute();
        return new SuccessRestResponse();
    }
}
