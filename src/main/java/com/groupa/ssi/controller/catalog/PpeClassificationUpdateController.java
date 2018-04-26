package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.request.catalog.PpeClassificationRequest;
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
public class PpeClassificationUpdateController extends PpeClassificationAbstractController {

    private PpeClassificationService service;

    public PpeClassificationUpdateController(PpeClassificationService service) {
        this.service = service;
    }


    @ApiOperation(value = "Update personal protection equipment classification")
    @RequestMapping(
            value = "/{ppeClassificationId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updatePpeClassification(@PathVariable Integer ppeClassificationId,
                                              @RequestBody PpeClassificationRequest ppeClassificationRequest,
                                              @RequestParam(value = "userId") Integer userId) {
        PpeClassification ppeClassification = service.findById(ppeClassificationId);
        ppeClassification.setName(ppeClassificationRequest.getName());
        ppeClassification.setDescription(ppeClassificationRequest.getDescription());
        service.save(ppeClassification);

        return new SuccessRestResponse();
    }

}
