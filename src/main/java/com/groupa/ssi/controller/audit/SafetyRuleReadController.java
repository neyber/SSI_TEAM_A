package com.groupa.ssi.controller.audit;

import com.groupa.ssi.cmd.audit.SafetyRuleReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.audit.SafetyRuleResponse;
import com.groupa.ssi.response.audit.SafetyRuleResponseBuilder;
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
public class SafetyRuleReadController extends SafetyRuleAbstractController {

    private SafetyRuleReadCmd safetyRuleReadCmd;

    public SafetyRuleReadController(SafetyRuleReadCmd safetyRuleReadCmd) {
        this.safetyRuleReadCmd = safetyRuleReadCmd;
    }

    @ApiOperation(value = "Read a safety rule")
    @RequestMapping(
            value = "/{safetyRuleId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<SafetyRuleResponse> readSafetyRule(@PathVariable Integer safetyRuleId, @RequestParam(value = "userId") Integer userId) {
        safetyRuleReadCmd.setSafetyRuleId(safetyRuleId);
        safetyRuleReadCmd.execute();
        return new SingleRestResponse<>(SafetyRuleResponseBuilder.getInstance(safetyRuleReadCmd.getSafetyRule()).build());
    }
}
