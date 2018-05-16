package com.groupa.ssi.controller.saclassification;

import com.groupa.ssi.cmd.saclassification.SaCategoryListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.saClassification.SaCategoryResponse;
import com.groupa.ssi.response.saClassification.SaCategoryResponseBuilder;
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
        tags = SaCategoryAbstractController.TAG_NAME,
        description = SaCategoryAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SaCategoryListController extends SaCategoryAbstractController {
    @Autowired
    private SaCategoryListCmd cmd;

    @ApiOperation(value = "List of all sickness/accidents categories")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<SaCategoryResponse> getSaCategoryList(@RequestParam(value = "userId", required = false) Integer userId) {
        cmd.execute();

        List<SaCategoryResponse> result = cmd.getSaCategoryList().stream()
                .map(instance -> SaCategoryResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }
}
