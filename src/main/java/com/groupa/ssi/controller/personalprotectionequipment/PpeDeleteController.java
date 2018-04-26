package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class PpeDeleteController extends PpeAbstractController {

    private PpeService service;

    public PpeDeleteController(PpeService service){
        this.service = service;
    }

    @ApiOperation(value = "Delete personal protection equipment")
    @RequestMapping(
            value = "/{ppeId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deletePpe(@PathVariable Integer ppeId,
                                              @RequestParam(value = "userId") Integer userId) {
        service.deleteById(ppeId);
        return new SuccessRestResponse();
    }

}
