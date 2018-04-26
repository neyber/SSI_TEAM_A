package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.request.personalprotectionequipment.PpeRequest;
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
public class PpeUpdateController extends PpeAbstractController {

    private PpeService service;

    public PpeUpdateController(PpeService service) {
        this.service = service;
    }

    @ApiOperation(value = "Update personal protection equipment")
    @RequestMapping(
            value = "/{ppeId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updatePpe(@PathVariable Integer ppeId,
                                              @RequestBody PpeRequest ppeRequest,
                                              @RequestParam(value = "userId") Integer userId) {
        Ppe ppe = service.findById(ppeId);
        ppe.setName(ppeRequest.getName());
        ppe.setDescription(ppeRequest.getDescription());
        ppe.setPpeClassification(ppeRequest.getPpeClassification());
        service.save(ppe);

        return new SuccessRestResponse();
    }

}
