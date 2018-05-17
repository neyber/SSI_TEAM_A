package com.groupa.ssi.controller.saclassification;

import com.groupa.ssi.cmd.saclassification.SaTypeListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.saClassification.SaTypeResponse;
import com.groupa.ssi.response.saClassification.SaTypeResponseBuilder;
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

/*
Created on 13/5/18
@author: HENRYBC
*/
@Api(
        tags = SaTypeAbstractController.TAG_NAME,
        description = SaTypeAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SaTypeListController extends SaTypeAbstractController {

    @Autowired
    private SaTypeListCmd cmd;

    @ApiOperation(value = "List of all sickness/accidents types")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<SaTypeResponse> getSaTypeList(@RequestParam(value = "userId", required = false) Integer userId) {
        cmd.execute();

        List<SaTypeResponse> result = cmd.getSaTypeList().stream()
                .map(instance -> SaTypeResponseBuilder.getIsntance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }
}
