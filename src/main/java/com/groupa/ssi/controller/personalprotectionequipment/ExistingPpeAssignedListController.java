package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeAssignedListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.personalprotectionequipment.ExistingPpeAssignedResponse;
import com.groupa.ssi.response.personalprotectionequipment.ExistingPpeAssignedResponseBuilder;
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
 * Created on April 30, 2018
 * @author Walker Colina
 */
@Api(
        tags = ExistingPpeAssignedAbstractController.TAG_NAME,
        description = ExistingPpeAssignedAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class ExistingPpeAssignedListController extends ExistingPpeAssignedAbstractController {

    @Autowired
    private ExistingPpeAssignedListCmd cmd;

    @ApiOperation(value = "List of existing personal protection equipment assigned")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<ExistingPpeAssignedResponse> getExistingPpeAssignedList(@RequestParam(value = "userId", required = false) Integer userId) {
        cmd.execute();

        List<ExistingPpeAssignedResponse> result = cmd.getExistingPpeAssignedList().stream()
                .map(instance -> ExistingPpeAssignedResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }

}
