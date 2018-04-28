package com.groupa.ssi.controller.audit;

import com.groupa.ssi.cmd.audit.SafetyRuleListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.audit.SafetyRuleResponse;
import com.groupa.ssi.response.audit.SafetyRuleResponseBuilder;
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
        tags = SafetyRuleAbstractController.TAG_NAME,
        description = SafetyRuleAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SafetyRuleListController extends SafetyRuleAbstractController {

    private SafetyRuleListCmd safetyRuleListCmd;

    public SafetyRuleListController(SafetyRuleListCmd safetyRuleListCmd) {
        this.safetyRuleListCmd = safetyRuleListCmd;
    }

    @ApiOperation(value = "List of safety rules")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<SafetyRuleResponse> getSafetyRuleList(@RequestParam(value = "userId") Integer userId) {
        safetyRuleListCmd.execute();

        List<SafetyRuleResponse> safetyRuleResponses = safetyRuleListCmd.getSafetyRuleList().stream()
                .map(instance -> SafetyRuleResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(safetyRuleResponses);
    }
}
