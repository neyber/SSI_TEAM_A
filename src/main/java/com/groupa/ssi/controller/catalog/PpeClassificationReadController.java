package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.response.catalog.PpeClassificationResponse;
import com.groupa.ssi.response.catalog.PpeClassificationResponseBuilder;
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
public class PpeClassificationReadController extends PpeClassificationAbstractController {

    private PpeClassificationService service;

    public PpeClassificationReadController(PpeClassificationService service) {
        this.service = service;
    }

    @ApiOperation(value = "Read a personal protection equipment classification")
    @RequestMapping(
            value = "/{ppeClassificationId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<PpeClassificationResponse> readPpeClassification(@PathVariable Integer ppeClassificationId,
                                                                               @RequestParam(value = "userId") Integer userId) {
        PpeClassification ppeClassification = service.findById(ppeClassificationId);
        return new SingleRestResponse(PpeClassificationResponseBuilder.getInstance(ppeClassification).build());
    }

}
