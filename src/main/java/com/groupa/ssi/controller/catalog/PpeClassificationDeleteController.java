package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.services.catalog.PpeClassificationService;
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
public class PpeClassificationDeleteController extends PpeClassificationAbstractController {

    private PpeClassificationService service;

    public PpeClassificationDeleteController(PpeClassificationService ppeClassificationService){
        this.service = ppeClassificationService;
    }

    @ApiOperation(value = "Delete personal protection equipment classification")
    @RequestMapping(
            value = "/{ppeClassificationId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deletePpeClassification(@PathVariable Integer ppeClassificationId,
                                              @RequestParam(value = "userId") Integer userId) {
        service.deleteById(ppeClassificationId);

        return new SuccessRestResponse();
    }

}
