package com.groupa.ssi.controller.saclassification;

/*
Created on 13/5/18
@author: HENRYBC
*/

import com.groupa.ssi.cmd.saclassification.SaCategoryCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.saclassification.SaCategoryRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = SaCategoryAbstractController.TAG_NAME,
        description = SaCategoryAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SaCategoryCreateController extends SaCategoryAbstractController {

    @Autowired
    private SaCategoryCreateCmd cmd;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createSaCategory(@RequestBody SaCategoryRequest saCategoryRequest,
                                                @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setSaCategoryRequest(saCategoryRequest);
        cmd.execute();
        return new SuccessRestResponse();
    }
}
