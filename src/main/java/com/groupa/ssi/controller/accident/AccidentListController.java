/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.accident;


import com.groupa.ssi.cmd.accident.AccidentCreateCmd;
import com.groupa.ssi.cmd.accident.AccidentListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.accident.AccidentResponse;
import com.groupa.ssi.response.accident.AccidentResponseBuilder;
import com.groupa.ssi.response.catalog.WorkItemResponse;
import com.groupa.ssi.response.catalog.WorkItemResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(
        tags = AccidentAbstractController.TAG_NAME,
        description = AccidentAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class AccidentListController extends AccidentAbstractController{

    @Autowired
    private AccidentListCmd cmd;

    @ApiOperation(value = "List of all accidents")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<AccidentResponse> getAccidentList(@RequestParam(value = "userId") Integer userId){
        cmd.execute();

        List<AccidentResponse> result = cmd.getAccidentList().stream()
                .map(instance -> AccidentResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }
}
