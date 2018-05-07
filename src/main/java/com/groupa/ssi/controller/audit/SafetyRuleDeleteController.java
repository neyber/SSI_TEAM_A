package com.groupa.ssi.controller.audit;

import com.groupa.ssi.cmd.audit.SafetyRuleDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class SafetyRuleDeleteController extends SafetyRuleAbstractController {

    private SafetyRuleDeleteCmd safetyRuleDeleteCmd;

    public SafetyRuleDeleteController(SafetyRuleDeleteCmd safetyRuleDeleteCmd) {
        this.safetyRuleDeleteCmd = safetyRuleDeleteCmd;
    }

    @ApiOperation(value = "Delete safety rule")
    @RequestMapping(
            value = "/{safetyRuleId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteSafetyRule(@PathVariable Integer safetyRuleId, @RequestParam(value = "userId", required = false) Integer userId) {
        safetyRuleDeleteCmd.setSafetyRuleId(safetyRuleId);
        safetyRuleDeleteCmd.execute();
        return new SuccessRestResponse();
    }
}
