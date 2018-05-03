package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.PpeListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.personalprotectionequipment.PpeResponse;
import com.groupa.ssi.response.personalprotectionequipment.PpeResponseBuilder;
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
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Api(
        tags = PpeAbstractController.TAG_NAME,
        description = PpeAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class PpeListController extends PpeAbstractController {

    @Autowired
    private PpeListCmd cmd;

    @ApiOperation(value = "List of personal protection equipment")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<PpeResponse> getPpeList(@RequestParam(value = "userId", required = false) Integer userId) {
        cmd.execute();

        List<PpeResponse> result = cmd.getPpeList().stream()
                .map(instance -> PpeResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }

}
