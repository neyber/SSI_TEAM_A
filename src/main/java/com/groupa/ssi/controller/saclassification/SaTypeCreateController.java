package com.groupa.ssi.controller.saclassification;

import com.groupa.ssi.cmd.saclassification.SaTypeCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.saclassification.SaTypeRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

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
public class SaTypeCreateController extends SaTypeAbstractController {

    @Autowired
    private SaTypeCreateCmd cmd;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createSaType(@RequestBody SaTypeRequest saTypeRequest,
                                            @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setSaTypeRequest(saTypeRequest);
        cmd.execute();
        return new SuccessRestResponse();
    }
}
