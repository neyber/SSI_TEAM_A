/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.cmd.sickness.SicknessListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.accident.AccidentResponse;
import com.groupa.ssi.response.accident.AccidentResponseBuilder;
import com.groupa.ssi.response.sickness.SicknessResponse;
import com.groupa.ssi.response.sickness.SicknessResponseBuilder;
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
        tags = SicknessAbstractController.TAG_NAME,
        description = SicknessAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SicknessListController extends SicknessAbstractController{

    @Autowired
    private SicknessListCmd cmd;

    @ApiOperation(value = "List of all diseases")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<SicknessResponse> getSicknessList(@RequestParam(value = "userId", required = false) Integer userId){
        cmd.execute();

        List<SicknessResponse> result = cmd.getSicknessList().stream()
                .map(instance -> SicknessResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }
}
