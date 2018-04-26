package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.personalprotectionequipment.ExistingPpeResponse;
import com.groupa.ssi.response.personalprotectionequipment.ExistingPpeResponseBuilder;
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
 * Created on April 26, 2018
 * @author Walker Colina
 */
@Api(
        tags = ExistingPpeAbstractController.TAG_NAME,
        description = ExistingPpeAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class ExistingPpeListController extends ExistingPpeAbstractController {

    private ExistingPpeListCmd cmd;

    public ExistingPpeListController(ExistingPpeListCmd cmd) {
        this.cmd = cmd;
    }

    @ApiOperation(value = "List of existing personal protection equipment")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<ExistingPpeResponse> getPpeList(@RequestParam(value = "userId") Integer userId) {
        cmd.execute();

        List<ExistingPpeResponse> result = cmd.getExistingPpeList().stream()
                .map(instance -> ExistingPpeResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }

}
