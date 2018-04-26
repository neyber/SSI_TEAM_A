package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.response.personalprotectionequipment.PpeResponse;
import com.groupa.ssi.response.personalprotectionequipment.PpeResponseBuilder;
import com.groupa.ssi.services.personalprotectionequipment.PpeService;
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
public class PpeReadController extends PpeAbstractController {

    private PpeService service;

    public PpeReadController(PpeService service) {
        this.service = service;
    }

    @ApiOperation(value = "Read a personal protection equipment")
    @RequestMapping(
            value = "/{ppeId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<PpeResponse> readPpe(@PathVariable Integer ppeId,
                                                                 @RequestParam(value = "userId") Integer userId) {

        Ppe ppe = service.findById(ppeId);
        return new SingleRestResponse<>(PpeResponseBuilder.getInstance(ppe).build());
    }


}
