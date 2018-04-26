/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.sickness.SicknessRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = SicknessAbstractController.TAG_NAME,
        description = SicknessAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SicknessCreateController extends SicknessAbstractController{

    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createSicknessRecord(@RequestBody SicknessRequest sicknessRequest,
                                                    @RequestParam(value = "userId") Integer userId){
        return new SuccessRestResponse();
    }
}
