/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.sickness.SicknessResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;

@Api(
        tags = SicknessAbstractController.TAG_NAME,
        description = SicknessAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SicknessListController extends SicknessAbstractController{

    @ApiOperation(value = "List of all diseases")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<SicknessResponse> getSicknessList(@RequestParam(value = "userId") Integer userId){
        return new ListRestResponse<>(new ArrayList<>());
    }
}
