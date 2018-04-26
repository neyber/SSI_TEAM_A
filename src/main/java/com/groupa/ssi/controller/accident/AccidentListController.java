/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.accident;


import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.accident.AccidentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;

@Api(
        tags = AccidentAbstractController.TAG_NAME,
        description = AccidentAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class AccidentListController extends AccidentAbstractController{

    @ApiOperation(value = "List of all accidents")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<AccidentResponse> getAccidentList(@RequestParam(value = "userId") Integer userId){
        System.out.println(" Implementation pending... getAccidentList" );
        return new ListRestResponse<>(new ArrayList<>());
    }
}
