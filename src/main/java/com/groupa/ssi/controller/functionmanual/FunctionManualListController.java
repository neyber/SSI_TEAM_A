package com.groupa.ssi.controller.functionmanual;

import com.groupa.ssi.cmd.functionmanual.FunctionManualListCmd;
import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.functionmanual.FunctionManualResponse;
import com.groupa.ssi.response.functionmanual.FunctionManualResponseBuilder;
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
 * @author Marcelo Loayza
 */

@Api(tags = FunctionManualAbstractController.TAG_NAME, description = FunctionManualAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class FunctionManualListController extends FunctionManualAbstractController {

    private FunctionManualListCmd cmd;

    public FunctionManualListController(FunctionManualListCmd cmd) { this.cmd = cmd; }

    @ApiOperation(value = "List UserManuals")
    @RequestMapping(method = RequestMethod.GET)

    public ListRestResponse<FunctionManualResponse> getManualList(@RequestParam(value="userId", required = false) Integer userId){

        cmd.execute();

        List<FunctionManualResponse> result = cmd.getFunctionManualList().stream()
                .map(instance -> FunctionManualResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }
}