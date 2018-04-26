package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.personalprotectionequipment.PpeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

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
public class PpeUpdateController extends PpeAbstractController {


    @ApiOperation(value = "Update personal protection equipment")
    @RequestMapping(
            value = "/{ppeId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updatePpeClassification(@PathVariable Integer ppeId,
                                              @RequestBody PpeRequest ppeRequest,
                                              @RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... updatePpe" );
        return new SuccessRestResponse();
    }

}
