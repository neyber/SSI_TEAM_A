package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.catalog.PpeClassificationRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Api(
        tags = PpeClassificationAbstractController.TAG_NAME,
        description = PpeClassificationAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class PpeClassificationUpdateController extends PpeClassificationAbstractController {


    @ApiOperation(value = "Update personal protection equipment")
    @RequestMapping(
            value = "/{ppeClassificationId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updatePpeClassification(@PathVariable Integer ppeClassificationId,
                                              @RequestBody PpeClassificationRequest ppeClassificationRequest,
                                              @RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... updatePpeClassification" );
        return new SuccessRestResponse();
    }

}
